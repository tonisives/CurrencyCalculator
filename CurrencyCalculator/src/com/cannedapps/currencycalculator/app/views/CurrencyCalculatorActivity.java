package com.cannedapps.currencycalculator.app.views;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContextSingleton;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.cannedapps.currencycalculator.R;
import com.cannedapps.currencycalculator.app.presenters.CurrencyCalculatorPresenter;
import com.cannedapps.currencycalculator.app.views.interfaces.ICurrencyCalculatorActivity;
import com.google.inject.Inject;

@ContextSingleton
public class CurrencyCalculatorActivity extends RoboActivity
    implements
      ICurrencyCalculatorActivity,
      OnItemSelectedListener,
      TextWatcher {

  @InjectView(R.id.convertedValue)
  TextView result;
  @InjectView(R.id.fromCurrency)
  Spinner from;
  @InjectView(R.id.toCurrency)
  Spinner to;
  @InjectView(R.id.input)
  EditText input;
  @Inject CurrencyCalculatorPresenter presenter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
//    presenter = new CurrencyCalculatorPresenter(this);
    populateSpinners();
    input.addTextChangedListener(this);
  }

  private void populateSpinners() {
    ArrayAdapter<String> fromAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
        presenter.getCurrencies());
    from.setAdapter(fromAdapter);
    from.setOnItemSelectedListener(this);

    ArrayAdapter<String> toAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
        presenter.getCurrencies());
    to.setAdapter(toAdapter);
    to.setOnItemSelectedListener(this);

  }

  @Override
  public void showConvertValue(String value) {
    result.setText(value);
  }

  @Override
  public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

    presenter.convert(input.getText().toString(), from.getSelectedItem().toString(), to.getSelectedItem().toString());
  }

  @Override
  public void onNothingSelected(AdapterView<?> arg0) {
    showConvertValue("");
  }

  @Override
  public void afterTextChanged(Editable s) {

  }

  @Override
  public void beforeTextChanged(CharSequence s, int start, int count, int after) {

  }

  @Override
  public void onTextChanged(CharSequence s, int start, int before, int count) {
    presenter.convert(input.getText().toString(), from.getSelectedItem().toString(), to.getSelectedItem().toString());

  }
}