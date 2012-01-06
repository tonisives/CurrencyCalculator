package com.cannedapps.currencycalculator.mocks;

import com.cannedapps.currencycalculator.app.views.interfaces.ICurrencyCalculatorActivity;

public class MockCurrencyCalculatorActivity implements ICurrencyCalculatorActivity {

  public String mValue;

  @Override
  public void showConvertValue(String value) {
    mValue = value;
  }
}
