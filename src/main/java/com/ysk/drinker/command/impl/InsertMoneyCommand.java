package com.ysk.drinker.command.impl;

import com.ysk.drinker.command.VendingCommand;
import com.ysk.drinker.model.VendingMachine;

import reactor.core.publisher.Mono;

public class InsertMoneyCommand implements VendingCommand<String> {
  private final VendingMachine machine;
  private final int amount;

  public InsertMoneyCommand(VendingMachine machine, int amount) {
    this.machine = machine;
    this.amount = amount;
  }

  @Override
  public Mono<String> execute() {
    return machine.insertMoney(amount);
  }
}
