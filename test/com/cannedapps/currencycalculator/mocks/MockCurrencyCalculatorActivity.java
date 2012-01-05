package com.cannedapps.currencycalculator.mocks;

import roboguice.inject.ContextSingleton;

import com.cannedapps.currencycalculator.app.views.interfaces.ICurrencyCalculatorActivity;

@ContextSingleton
public class MockCurrencyCalculatorActivity implements ICurrencyCalculatorActivity {

  public String mValue;

  @Override
  public void showConvertValue(String value) {
    mValue = value;
  }
}
