package com.ysk.drinker.command.impl;

import com.ysk.drinker.command.VendingCommand;
import com.ysk.drinker.model.VendingMachine;

import reactor.core.publisher.Mono;

public class CancelCommand implements VendingCommand<String> {
  private final VendingMachine machine;

  public CancelCommand(VendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public Mono<String> execute() {
    int refund = machine.getCurrentAmount();
    machine.setCurrentAmount(0);
    machine.setState(machine.getIdleState());
    return Mono.just("Transaction cancelled. Refunded amount: " + refund + "yen.");
  }
}
