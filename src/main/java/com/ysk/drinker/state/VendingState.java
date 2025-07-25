package com.ysk.drinker.state;

import com.ysk.drinker.model.Drink;

import reactor.core.publisher.Mono;

public interface VendingState {
  Mono<String> insertMoney(int amount);
  Mono<Drink> selectDrink(String name);
}
