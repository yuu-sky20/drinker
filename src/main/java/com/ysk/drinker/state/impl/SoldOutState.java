package com.ysk.drinker.state.impl;

import com.ysk.drinker.model.Drink;
import com.ysk.drinker.model.VendingMachine;
import com.ysk.drinker.state.VendingState;

import reactor.core.publisher.Mono;

public class SoldOutState implements VendingState {

  private final VendingMachine machine;

  public SoldOutState(VendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public Mono<String> insertMoney(int amount) {
    return Mono.error(new IllegalStateException("Cannot insert money, drinks are sold out"));
  }

  @Override
  public Mono<Drink> selectDrink(String name) {
    return Mono.error(new IllegalStateException("Cannot select drink, drinks are sold out"));
  }

}
