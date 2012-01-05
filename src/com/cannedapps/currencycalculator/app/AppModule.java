package com.cannedapps.currencycalculator.app;

import com.cannedapps.currencycalculator.app.views.CurrencyCalculatorActivity;
import com.cannedapps.currencycalculator.app.views.interfaces.ICurrencyCalculatorActivity;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {

  public AppModule() {
    
  }
  
  @Override
  protected void configure() {
    bind(ICurrencyCalculatorActivity.class).to(CurrencyCalculatorActivity.class);
  }
}
