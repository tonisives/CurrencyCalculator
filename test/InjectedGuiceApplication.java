import java.util.List;

import com.cannedapps.currencycalculator.app.CurrencyCalculatorApplication;
import com.google.inject.Module;

import roboguice.application.RoboApplication;


public class InjectedGuiceApplication extends CurrencyCalculatorApplication {
  private Module module= new InjectedMockActivityModule();
  
  @Override
  protected void addApplicationModules(List<Module> modules) {
    modules.add(module);
  }
  
  public void setModule(Module module) {
    this.module= module;
  }
}
