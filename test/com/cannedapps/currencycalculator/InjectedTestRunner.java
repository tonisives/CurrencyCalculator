package com.cannedapps.currencycalculator;

import java.lang.reflect.Method;

import org.junit.runners.model.InitializationError;

import roboguice.RoboGuice;

import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

public class InjectedTestRunner extends RobolectricTestRunner {
  public InjectedTestRunner(Class<?> testClass) throws InitializationError {
    super(testClass);
  }

  @Override
  public void prepareTest(Object test) {
    Module module = Modules.override(RoboGuice.newDefaultRoboModule(Robolectric.application)).with(new MockActivitiesModule());
    RoboGuice.setBaseApplicationInjector(Robolectric.application, RoboGuice.DEFAULT_STAGE, module);
    RoboGuice.getInjector(Robolectric.application).injectMembers(test);
  }

  @Override
  public void afterTest(Method method) {
    RoboGuice.util.reset();
    super.afterTest(method);
  }
}
