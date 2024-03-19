package com.wipro.sec04.helper;

import java.time.Duration;

import com.wipro.common.Util;

import reactor.core.publisher.Flux;

public class Indigo {
	public static Flux<String> getFlights() {
		return Flux.range(1, Util.faker()
				.random()
				.nextInt(1, 10))
				
				.delayElements(Duration.ofSeconds(1))
				
				.map(i -> "Indigo " + Util.faker()
						.random()
						.nextInt(100, 999))
				
				.filter(i -> Util.faker()
						.random()
						.nextBoolean());
	}

}
