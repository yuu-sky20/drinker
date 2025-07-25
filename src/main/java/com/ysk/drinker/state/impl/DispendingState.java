package com.ysk.drinker.state.impl;

import com.ysk.drinker.model.Drink;
import com.ysk.drinker.model.VendingMachine;
import com.ysk.drinker.state.VendingState;

import reactor.core.publisher.Mono;

public class DispendingState implements VendingState {

  private final VendingMachine machine;

  public DispendingState(VendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public Mono<String> insertMoney(int amount) {
    return Mono.error(new IllegalStateException("Cannot insert money while dispensing"));
  }

  @Override
  public Mono<Drink> selectDrink(String name) {
    return Mono.error(new IllegalStateException("Cannot select drink while dispensing"));
  }

}
