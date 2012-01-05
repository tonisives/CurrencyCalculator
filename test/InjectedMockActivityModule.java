import roboguice.config.AbstractAndroidModule;
import android.app.Activity;

import com.cannedapps.currencycalculator.app.views.CurrencyCalculatorActivity;


public class InjectedMockActivityModule extends AbstractAndroidModule {

  @Override
  protected void configure() {
    
    bind(Activity.class).to(CurrencyCalculatorActivity.class);
  }

}
