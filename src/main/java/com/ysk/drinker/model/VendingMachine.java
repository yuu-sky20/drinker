package com.ysk.drinker.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ysk.drinker.state.VendingState;
import com.ysk.drinker.state.impl.DispendingState;
import com.ysk.drinker.state.impl.HasMoneyState;
import com.ysk.drinker.state.impl.IdleState;
import com.ysk.drinker.state.impl.SoldOutState;

import reactor.core.publisher.Mono;

public class VendingMachine {
  private final Map<String, Drink> inventory = new ConcurrentHashMap<>();

  private VendingState state;
  private final VendingState idleState;
  private final VendingState hasMoneyState;
  private final VendingState dispendingState;
  private final VendingState soldOutState;

  private int currentAmount;

  public VendingMachine() {
    inventory.put("cola", new Drink("Cola", 120, true));
    inventory.put("tea", new Drink("Tea", 100, true));

    this.idleState = new IdleState(this);
    this.hasMoneyState = new HasMoneyState(this);
    this.dispendingState = new DispendingState(this);
    this.soldOutState = new SoldOutState(this);

    this.state = idleState;
  }

  public Mono<String> insertMoney(int amount) {
    return state.insertMoney(amount);
  }

  public Mono<Drink> selectDrink(String name) {
    return state.selectDrink(name);
  }

  public Map<String, Drink> getInventory() { return inventory; }
  public VendingState getIdleState() { return idleState; }
  public VendingState getHashMoneyState() { return hasMoneyState; }
  public VendingState getDispensingState() { return dispendingState; }
  public VendingState getSoldOutState() { return soldOutState; }
  public void setState(VendingState state) { this.state = state; }
  public int getCurrentAmount() { return currentAmount; }
  public void setCurrentAmount(int currentAmount) { this.currentAmount = currentAmount; }
}