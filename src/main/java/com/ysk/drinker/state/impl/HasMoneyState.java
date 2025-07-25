package com.ysk.drinker.state.impl;

import com.ysk.drinker.model.Drink;
import com.ysk.drinker.model.VendingMachine;
import com.ysk.drinker.state.VendingState;

import reactor.core.publisher.Mono;

public class HasMoneyState implements VendingState {

  private final VendingMachine machine;

  public HasMoneyState(VendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public Mono<String> insertMoney(int amount) {
    return Mono.just("Money already inserted: " + amount + "yen.");
  }

  @Override
  public Mono<Drink> selectDrink(String name) {
    Drink drink = machine.getInventory().get(name);

    if (drink == null || !drink.isAvailable()) {
      machine.setState(machine.getIdleState());
      return Mono.error(new IllegalArgumentException("Drink not available or not found"));
    }

    if (!drink.isAvailable()) {
      machine.setState(machine.getIdleState());
      return Mono.error(new IllegalArgumentException("Drink not available"));
    }

    int price = machine.getCalculatedPrice(drink);

    if (machine.getCurrentAmount() < price) {
      return Mono.error(new IllegalArgumentException("Insufficient funds"));
    }


    machine.setCurrentAmount(machine.getCurrentAmount() - price);
    machine.setState(machine.getIdleState());


    return Mono.just(drink)
      .delayElement(java.time.Duration.ofSeconds(1))
      .doOnNext(_ -> {
        drink.setAvailable(false);
        machine.setState(machine.getIdleState());
      });
  }
}
