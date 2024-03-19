package com.wipro.sec04;

import com.wipro.common.Util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxDefaultSwitchIfEmpty {
	public static void main(String[] args) {

		getNumbers().filter(i -> i > 10)
				//.log()
				//.defaultIfEmpty(100)
				.switchIfEmpty(fallback())
				//.log()
				.subscribe(Util.subscriber());
	}

	private static Flux<Integer> getNumbers() {
		return Flux.range(1, 10);
	}

	private static Flux<Integer> fallback() {
		return Flux.range(100, 5);
	}

}
