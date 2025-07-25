package com.ysk.drinker.model;

public class Drink {
  private final String name;
  private final int price;
  private boolean available;

  public Drink(String name, int price, boolean available) {
    this.name = name;
    this.price = price;
    this.available = available;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }
}
