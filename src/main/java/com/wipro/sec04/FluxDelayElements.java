package com.wipro.sec04;

import java.time.Duration;

import com.wipro.common.Util;

import reactor.core.publisher.Flux;

public class FluxDelayElements {
	public static void main(String[] args) {

		Flux.range(1, 300)
				.log()
				.delayElements(Duration.ofSeconds(1))
				.subscribe(Util.subscriber());
		
		Util.sleep(30);
	}

}
