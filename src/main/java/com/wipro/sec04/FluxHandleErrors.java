package com.wipro.sec04;

import com.wipro.common.Util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxHandleErrors {
	public static void main(String[] args) {

		Flux.range(1, 10)
				.log()
				.map(i -> 10 / (5 - i))
				// .onErrorReturn(-1)
				// .onErrorResume(t -> fallback())
				/*
				 * .onErrorContinue((ex, obj) -> { log.error("Error occured for {} {}", obj,
				 * ex.getMessage()); })
				 */
				.onErrorComplete()
				.log()
				.subscribe(Util.subscriber());

	}

	private static Flux<Integer> fallback() {
		return Flux.just(1, 2, 3, 4, 5);
	}

}
