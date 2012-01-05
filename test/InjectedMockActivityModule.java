import com.cannedapps.currencycalculator.app.views.interfaces.ICurrencyCalculatorActivity;
import com.google.inject.AbstractModule;

import fakes.TestingCurrencyCalculatorActivity;

public class InjectedMockActivityModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(ICurrencyCalculatorActivity.class).to(TestingCurrencyCalculatorActivity.class);
  }

}
