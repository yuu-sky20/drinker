package com.ysk.drinker.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysk.drinker.model.Drink;
import com.ysk.drinker.service.VendingMachineService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/vending")
public class VendingMachineController {
  private final VendingMachineService service;

  public VendingMachineController(VendingMachineService service) {
    this.service = service;
  }

  @GetMapping("/drinks")
  public Mono<Map<String, Drink>> listDrinks() {
    return service.listDrinks();
  }

  @PostMapping("/buy/{name}")
  public Mono<Drink> buyDrink(@PathVariable String name) {
    return service.buyDrink(name);
  }

  @GetMapping("/state")
  public Mono<Map<String, String>> getState() {
    return service.getCurrentState();
  }
}
