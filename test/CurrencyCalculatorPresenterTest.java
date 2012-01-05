import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import roboguice.inject.InjectView;
import android.widget.TextView;

import com.cannedapps.currencycalculator.R;
import com.cannedapps.currencycalculator.app.presenters.CurrencyCalculatorPresenter;
import com.cannedapps.currencycalculator.app.views.CurrencyCalculatorActivity;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class CurrencyCalculatorPresenterTest {
  private CurrencyCalculatorActivity activity;
  private CurrencyCalculatorPresenter presenter;

  @Before
  public void setUp() throws Exception {
    activity = new CurrencyCalculatorActivity();
    presenter = new CurrencyCalculatorPresenter();
    activity.onCreate(null);
  }

  @Test
  public void shouldConvertFromCurrencyToCurrency() {

    presenter.convert("100", "EUR", "USD");

//    assertThat(activity.mValue, equalTo("120.00"));

  }

  @Test
  public void shouldNotChangeValueWhenSameCurrency() {
    presenter.convert("100", "USD", "USD");
    //    assertThat(activity.mValue, equalTo("100.00"));
  }

  @Test
  public void shouldDisplayNothingIfWrongValue() {
    presenter.convert("asd", "SEK", "SEK");
    //    assertThat(activity.mValue, equalTo(""));
  }

}
