package com.ysk.drinker.command.impl;

import com.ysk.drinker.command.VendingCommand;
import com.ysk.drinker.model.VendingMachine;
import com.ysk.drinker.strategy.impl.FreeForVIPStrategy;
import com.ysk.drinker.strategy.impl.HappyHourStrategy;
import com.ysk.drinker.strategy.impl.NormalPriceStrategy;

import reactor.core.publisher.Mono;


public class ChangeStrategyCommand implements VendingCommand<String> {
  private final VendingMachine machine;
  private final String type;

  public ChangeStrategyCommand(VendingMachine machine, String type) {
    this.machine = machine;
    this.type = type;
  }

  @Override
  public Mono<String> execute() {
    switch (type) {
      case "normal" -> machine.setPriceStrategy(new NormalPriceStrategy());
      case "happyhour" -> machine.setPriceStrategy(new HappyHourStrategy());
      case "vip" -> machine.setPriceStrategy(new FreeForVIPStrategy());
      default -> {
          return Mono.error(new IllegalArgumentException("Unknown strategy type: " + type));
        }
    }
    return Mono.just("Strategy set to: " + type);
  }
}
