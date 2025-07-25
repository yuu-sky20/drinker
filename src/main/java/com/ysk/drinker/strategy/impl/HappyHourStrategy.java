package com.ysk.drinker.strategy.impl;

import com.ysk.drinker.model.Drink;
import com.ysk.drinker.strategy.PriceStrategy;

public class HappyHourStrategy implements PriceStrategy {

    private final int discountPrice = 50;

    @Override
    public int calculatePrice(Drink drink) {
        return Math.max(0, drink.getPrice() - discountPrice);
    }
}
