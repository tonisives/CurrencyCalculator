package com.cannedapps.currencycalculator.app.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Currency {
  public static List<Currency> getAll() {
    List<Currency> list = new ArrayList<Currency>();

    list.add(new Currency("EUR", 1.0));
    list.add(new Currency("USD", 1.2));
    list.add(new Currency("GBP", 0.8));

    return list;
  }

  private String mName;
  private double mRate;

  private Currency(String name, double rate) {
    mName = name;
    mRate = rate;
  }

  public String getName() {
    return mName;
  }

  public double getRate() {
    return mRate;
  }

  public static Currency getCurrency(String name) {
    List<Currency> currencies = getAll();
    for (Iterator iterator = currencies.iterator(); iterator.hasNext();) {
      Currency currency = (Currency) iterator.next();
      if (currency.getName().equalsIgnoreCase(name)) {
        return currency;
      }
    }
    throw new IllegalArgumentException("No such Currency");
  }

  public static double convert(double value, Currency from, Currency to) {
    double result =value / from.getRate() * to.getRate();
    result = Math.round(result*100.0)/100.0;
    return result;

  }

}
