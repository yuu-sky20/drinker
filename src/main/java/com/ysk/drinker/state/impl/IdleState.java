package com.ysk.drinker.state.impl;

import com.ysk.drinker.model.Drink;
import com.ysk.drinker.model.VendingMachine;
import com.ysk.drinker.state.VendingState;

import reactor.core.publisher.Mono;

public class IdleState implements VendingState {
  private final VendingMachine machine;

  public IdleState(VendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public Mono<String> insertMoney(int amount) {
    machine.setCurrentAmount(amount);
    machine.setState(machine.getHashMoneyState());

    return Mono.just("Money inserted: " + amount + "yen");
  }

  @Override
  public Mono<Drink> selectDrink(String name) {
    return Mono.error(new IllegalStateException("Please insert money first"));
  }
}
