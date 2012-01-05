package fakes;

import com.cannedapps.currencycalculator.app.views.interfaces.ICurrencyCalculatorActivity;

public class TestingCurrencyCalculatorActivity implements ICurrencyCalculatorActivity {

  public String mValue;

  @Override
  public void showConvertValue(String value) {
    mValue = value;
  }
}
