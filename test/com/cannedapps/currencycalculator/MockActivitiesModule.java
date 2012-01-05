package com.cannedapps.currencycalculator;

import com.cannedapps.currencycalculator.app.views.interfaces.ICurrencyCalculatorActivity;
import com.cannedapps.currencycalculator.providers.CurrencyCalculatorMockActivityProvider;
import com.google.inject.AbstractModule;

public class MockActivitiesModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ICurrencyCalculatorActivity.class).toProvider(CurrencyCalculatorMockActivityProvider.class);
  }

}
