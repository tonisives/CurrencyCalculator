package com.cannedapps.currencycalculator.app.views;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.cannedapps.currencycalculator.R;
import com.cannedapps.currencycalculator.app.models.Currency;
import com.jayway.android.robotium.solo.Solo;

public class CurrencyCalculationTest extends ActivityInstrumentationTestCase2<CurrencyCalculatorActivity> {
  private Solo solo;
  private Activity activity;
  private TextView result;
  private Spinner firstCurrency;
  private Spinner secondCurrency;

  public CurrencyCalculationTest() {
    super(CurrencyCalculatorActivity.class);
  }

  protected void setUp() throws Exception {
    super.setUp();
    this.activity = getActivity();
    solo = new Solo(getInstrumentation(), getActivity());
    result = (TextView) solo.getView(R.id.convertedValue);
    firstCurrency = (Spinner) solo.getView(R.id.fromCurrency);
    secondCurrency = (Spinner) solo.getView(R.id.toCurrency);
  }

  public void testShouldHaveRightAmountOfCurrenciesInSpinners() {
    int currencyCount = Currency.getAll().size();
    assertEquals(currencyCount, firstCurrency.getCount());
    assertEquals(currencyCount, secondCurrency.getCount());

  }

  public void testShouldReconvertWhenInputChanged() {
    solo.enterText(0, "7");
    String result1 = result.getText().toString();

    solo.enterText(0, "8");
    assertNotSame(result1, result.getText().toString());
  }

  public void testShouldReconvertWhenFirstSpinnerChanged() {
    solo.enterText(0, "8");
    String result1 = result.getText().toString();
    activity.runOnUiThread(new Runnable() {
      @Override
      public void run() {
        int selection = 0;
        while (selection == 0)
          selection = (int) (Math.random() * firstCurrency.getCount());

        firstCurrency.setSelection(selection);
      }
    });
    solo.waitForView(Spinner.class);
    assertNotSame(result1, result.getText().toString());
  }

  public void testShouldReconvertWhenSecondSpinnerChanged() {
    solo.enterText(0, "7");
    String result1 = result.getText().toString();
    activity.runOnUiThread(new Runnable() {
      @Override
      public void run() {
        int selection = 0;
        while (selection == 0)
          selection = (int) (Math.random() * secondCurrency.getCount());
        secondCurrency.setSelection(selection);
      }
    });
    solo.waitForView(Spinner.class);
    assertNotSame(result1, result.getText().toString());
  }

  @SmallTest
  public void testEur2GbpCalculation() {
    solo.enterText(0, "100");
    solo.pressSpinnerItem(1, 2); // To: GBP

    assertTrue(solo.searchText("80.00"));
  }

  @SmallTest
  public void testGbp2EurCalculation() {
    solo.enterText(0, "80");
    solo.pressSpinnerItem(0, 2); // From: GBP

    assertTrue(solo.searchText("100.00"));
  }

  @SmallTest
  public void testEur2EurCalculation() {
    solo.enterText(0, "100");

    assertTrue(solo.searchText("100.00"));
  }

  @SmallTest
  public void testInvalidValue() {
    solo.enterText(0, "antani");

    solo.pressSpinnerItem(0, 1);
    solo.pressSpinnerItem(1, 2);

    TextView result = (TextView) solo.getView(R.id.convertedValue);
    assertEquals("", result.getText().toString());
  }

  @SmallTest
  public void testInputTextRetentionOnScreenRotation() {
    solo.enterText(0, "42");

    solo.setActivityOrientation(Solo.LANDSCAPE);

    assertTrue(solo.searchText("42"));
  }
}
