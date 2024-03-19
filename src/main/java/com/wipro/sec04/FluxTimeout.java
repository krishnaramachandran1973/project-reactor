package com.wipro.sec04;

import java.time.Duration;

import com.wipro.common.Util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxTimeout {
	public static void main(String[] args) {
		getNumbers().timeout(Duration.ofSeconds(2), fallback())
				.subscribe(Util.subscriber());

		Util.sleep(10);

	}

	private static Flux<Integer> getNumbers() {
		return Flux.range(1, 10)
				.delayElements(Duration.ofSeconds(5));
	}

	private static Flux<Integer> fallback() {
		return Flux.range(100, 10)
				.delayElements(Duration.ofMillis(200));
	}

}
