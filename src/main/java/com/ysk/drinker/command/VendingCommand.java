package com.ysk.drinker.command;

import reactor.core.publisher.Mono;

public interface VendingCommand<T> {
  Mono<T> execute();
}
