package com.cannedapps.currencycalculator.app.presenters;

import android.app.Activity;

import com.google.inject.Inject;

public abstract class AbstractCannedappsPresenter<T> {

  @Inject private Activity activity;
  @Inject private T view;
  
  T getView() {
    return view;
  }
  
  Activity getActivity() {
    return activity;
  }

}
