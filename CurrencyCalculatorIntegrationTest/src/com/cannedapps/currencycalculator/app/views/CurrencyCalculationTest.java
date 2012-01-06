package com.cannedapps.currencycalculator.app.views;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.TextView;

import com.cannedapps.currencycalculator.R;
import com.jayway.android.robotium.solo.Solo;

public class CurrencyCalculationTest extends ActivityInstrumentationTestCase2<CurrencyCalculatorActivity> {
  private Solo solo;
  
  public CurrencyCalculationTest() {
    super(CurrencyCalculatorActivity.class);
  }

  protected void setUp() throws Exception {
    super.setUp();
    solo = new Solo(getInstrumentation(), getActivity());
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
