import org.junit.runners.model.InitializationError;

import roboguice.inject.ContextScope;

import android.app.Application;

import com.cannedapps.currencycalculator.app.CurrencyCalculatorApplication;
import com.google.inject.Injector;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

public class InjectedTestRunner extends RobolectricTestRunner {

  public InjectedTestRunner(Class<?> testClass) throws InitializationError {
    super(testClass);
  }

  @Override
  protected Application createApplication() {
//    InjectedGuiceApplication app = (InjectedGuiceApplication) super.createApplication();
    InjectedGuiceApplication app = new InjectedGuiceApplication();
    app.setModule(new InjectedMockActivityModule());
    
    return app;
  }
  
  @Override
  public void prepareTest(Object test) {
    CurrencyCalculatorApplication app = (CurrencyCalculatorApplication) Robolectric.application;
    Injector injector = app.getInjector();
    ContextScope scope = injector.getInstance(ContextScope.class);
    scope.enter(app);
    injector.injectMembers(test);
  }
}
