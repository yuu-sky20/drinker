package com.ysk.drinker.strategy.impl;

import com.ysk.drinker.model.Drink;
import com.ysk.drinker.strategy.PriceStrategy;

public class FreeForVIPStrategy implements PriceStrategy {

    @Override
    public int calculatePrice(Drink drink) {
        return 0;
    }
}
