package com.cannedapps.currencycalculator.providers;

import com.cannedapps.currencycalculator.mocks.MockCurrencyCalculatorActivity;
import com.google.inject.Provider;

public class CurrencyCalculatorMockActivityProvider implements Provider<MockCurrencyCalculatorActivity> {
  private MockCurrencyCalculatorActivity instance = new MockCurrencyCalculatorActivity();

  @Override
  public MockCurrencyCalculatorActivity get() {
    return instance;
  }

}
