package com.wipro.sec04;

import com.wipro.common.Util;

import reactor.core.publisher.Flux;

public class FluxLimitRate {
	public static void main(String[] args) {

		Flux.range(1, 300)
		.log()
				.limitRate(100, 99) // 75%
				.subscribe(Util.subscriber());
	}

}
