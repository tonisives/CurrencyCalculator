package com.cannedapps.currencycalculator.app.presenters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cannedapps.currencycalculator.InjectedTestRunner;
import com.cannedapps.currencycalculator.mocks.MockCurrencyCalculatorActivity;
import com.google.inject.Inject;

@RunWith(InjectedTestRunner.class)
public class CurrencyCalculatorPresenterTest {
  @Inject
  private ArrayList<Object> list;
  @Inject
  private CurrencyCalculatorPresenter presenter;
  private MockCurrencyCalculatorActivity view;

  @Before
  public void setUp() throws Exception {
    view = (MockCurrencyCalculatorActivity) presenter.getView();
  }

  @Test
  public void shouldConvertFromCurrencyToCurrency() {
    presenter.convert("100", "EUR", "USD");
    assertThat(view.mValue, equalTo("120.00"));

  }

  @Test
  public void shouldNotChangeValueWhenSameCurrency() {
    presenter.convert("100", "USD", "USD");
    assertThat(view.mValue, equalTo("100.00"));
  }

  @Test
  public void shouldDisplayNothingIfWrongValue() {
    presenter.convert("asd", "SEK", "SEK");
    assertThat(view.mValue, equalTo(""));
  }

  @Test
  public void shouldInjectWork() {
    assertThat(list, org.hamcrest.CoreMatchers.notNullValue());
  }

}
