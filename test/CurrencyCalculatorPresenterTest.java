import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import roboguice.RoboGuice;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.TextView;

import com.cannedapps.currencycalculator.app.AppModule;
import com.cannedapps.currencycalculator.app.presenters.CurrencyCalculatorPresenter;
import com.cannedapps.currencycalculator.app.views.interfaces.ICurrencyCalculatorActivity;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

import fakes.TestingCurrencyCalculatorActivity;

@RunWith(RobolectricTestRunner.class)
public class CurrencyCalculatorPresenterTest {
  private Context context= new Activity();
  private TestingCurrencyCalculatorActivity activity;
  private CurrencyCalculatorPresenter presenter;
  TextView result;

//  @Inject Application app;
  
  public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
      bind(ICurrencyCalculatorActivity.class).toInstance(activity);
    }
  }
  @Before
  public void setUp() throws Exception {
    //    RoboGuice.setBaseApplicationInjector(arg0, arg1);
    //    Guice.createInjector(Modules.override(new AppModule()).with(new InjectedMockActivityModule()));
//    RoboGuice.setBaseApplicationInjector(Robolectric.application, RoboGuice.DEFAULT_STAGE,
//        Modules.override(RoboGuice.newDefaultRoboModule(Robolectric.application)).with(new InjectedMockActivityModule()));
//    RoboGuice.util.reset();
//    RoboGuice.setBaseApplicationInjector(Robolectric.application, RoboGuice.DEFAULT_STAGE, new InjectedMockActivityModule());
    activity = new TestingCurrencyCalculatorActivity();
    Module module = Modules.override(RoboGuice.newDefaultRoboModule(Robolectric.application)).with(new TestModule());
    RoboGuice.setBaseApplicationInjector(Robolectric.application, RoboGuice.DEFAULT_STAGE, module);
//    presenter = new CurrencyCalculatorPresenter();
    presenter = RoboGuice.getInjector(context).getInstance(CurrencyCalculatorPresenter.class);

  }

  @Test
  public void shouldConvertFromCurrencyToCurrency() {

    presenter.convert("100", "EUR", "USD");

    assertThat(activity.mValue, equalTo("120.00"));

  }
  //
  //  @Test
  //  public void shouldNotChangeValueWhenSameCurrency() {
  //    presenter.convert("100", "USD", "USD");
  //    //    assertThat(activity.mValue, equalTo("100.00"));
  //  }
  //
  //  @Test
  //  public void shouldDisplayNothingIfWrongValue() {
  //    presenter.convert("asd", "SEK", "SEK");
  //    //    assertThat(activity.mValue, equalTo(""));
  //  }

}
