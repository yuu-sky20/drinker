package com.ysk.drinker.strategy;

import com.ysk.drinker.model.Drink;

public interface PriceStrategy {
  int calculatePrice(Drink drink);
}
