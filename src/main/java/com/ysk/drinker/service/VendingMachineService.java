package com.ysk.drinker.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ysk.drinker.command.impl.BuyDrinkCommand;
import com.ysk.drinker.command.impl.CancelCommand;
import com.ysk.drinker.command.impl.InsertMoneyCommand;
import com.ysk.drinker.model.Drink;
import com.ysk.drinker.model.VendingMachine;

import reactor.core.publisher.Mono;

@Service
public class VendingMachineService {

  private final VendingMachine machine = new VendingMachine();

  public Mono<String> insertMoney(int amount) {
    return new InsertMoneyCommand(machine, amount).execute();
  }

  public Mono<Drink> buyDrink(String name) {
    return new BuyDrinkCommand(machine, name).execute();
  }

  public Mono<String> cancel() {
    return new CancelCommand(machine).execute();
  }

  public Mono<Map<String, Drink>> listDrinks() {
    return Mono.just(machine.getInventory());
  }

  public Mono<Map<String, String>> getCurrentState() {
    return Mono.just(Map.of("state", machine.getCurrentStateName()));
  }
}
