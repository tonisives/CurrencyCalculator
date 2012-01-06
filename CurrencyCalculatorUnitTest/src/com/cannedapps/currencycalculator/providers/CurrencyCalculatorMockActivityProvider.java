package com.cannedapps.currencycalculator.providers;

import com.cannedapps.currencycalculator.mocks.MockCurrencyCalculatorActivity;
import com.google.inject.Provider;

public class CurrencyCalculatorMockActivityProvider implements Provider<MockCurrencyCalculatorActivity> {
  
  MockCurrencyCalculatorActivity activity = new MockCurrencyCalculatorActivity();
  
  @Override
  public MockCurrencyCalculatorActivity get() {
    return activity;
  }

}
