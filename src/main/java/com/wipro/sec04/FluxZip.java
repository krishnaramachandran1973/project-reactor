package com.wipro.sec04;

import com.wipro.common.Util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxZip {
	public static void main(String[] args) {
		Flux.zip(getBody(), getEngine(), getTyres())
				.subscribe(Util.subscriber());
	}

	private static Flux<String> getBody() {
		return Flux.range(1, 5)
				.map(i -> "body");
	}

	private static Flux<String> getEngine() {
		return Flux.range(1, 3)
				.map(i -> "engine");
	}

	private static Flux<String> getTyres() {
		return Flux.range(1, 6)
				.map(i -> "tyre");
	}

}
