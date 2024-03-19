package com.wipro.sec04;

import java.time.Duration;

import com.wipro.common.Util;

import reactor.core.publisher.Flux;

public class FluxCombineLatest {
	public static void main(String[] args) {
		Flux.combineLatest(getString(), getNumber(), (s, n) -> s + n)
				.subscribe(Util.subscriber());
		
		Util.sleep(10);

	}

	// B1 - C1 - D2
	private static Flux<String> getString() {
		return Flux.just("A", "B", "C", "D")
				.delayElements(Duration.ofSeconds(1));
	}

	private static Flux<Integer> getNumber() {
		return Flux.just(1, 2, 3)
				.delayElements(Duration.ofSeconds(3));
	}

}
