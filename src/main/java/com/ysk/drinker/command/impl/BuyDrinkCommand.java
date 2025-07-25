package com.ysk.drinker.command.impl;

import com.ysk.drinker.command.VendingCommand;
import com.ysk.drinker.model.Drink;
import com.ysk.drinker.model.VendingMachine;

import reactor.core.publisher.Mono;

public class BuyDrinkCommand implements VendingCommand<Drink> {
  private final VendingMachine machine;
  private final String drinkName;

  public BuyDrinkCommand(VendingMachine machine, String drinkName) {
    this.machine = machine;
    this.drinkName = drinkName;
  }

  @Override
  public Mono<Drink> execute() {
    return machine.selectDrink(drinkName);
  }

}
