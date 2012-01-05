package com.cannedapps.currencycalculator.app.presenters;

import android.app.Activity;

import com.google.inject.Inject;

public abstract class AbstractCannedappsPresenter<T> {

  @Inject Activity activity;
  
  @SuppressWarnings("unchecked")
  T getView() {
    return (T) activity;
  }
  
  Activity getActivity() {
    return activity;
  }
  
}
