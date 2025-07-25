package com.ysk.drinker.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ysk.drinker.model.Drink;
import com.ysk.drinker.model.VendingMachine;

import reactor.core.publisher.Mono;

@Service
public class VendingMachineService {

  private final VendingMachine machine = new VendingMachine();

  public Mono<String> insertMoney(int amount) {
    return machine.insertMoney(amount);
  }

  public Mono<Drink> buyDrink(String name) {
    return machine.selectDrink(name);
  }

  public Mono<Map<String, Drink>> listDrinks() {
    return Mono.just(machine.getInventory());
  }

  public Mono<Map<String, String>> getCurrentState() {
    return Mono.just(Map.of("state", machine.getCurrentStateName()));
  }
}
