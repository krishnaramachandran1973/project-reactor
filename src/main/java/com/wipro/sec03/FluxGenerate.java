package com.wipro.sec03;

import com.wipro.common.Util;

import reactor.core.publisher.Flux;

public class FluxGenerate {
	public static void main(String[] args) {
		Flux.generate(synchronousSink -> {
			
			synchronousSink.next(Util.faker()
					.country()
					.name());
		})
				.take(3)
				.subscribeWith(Util.subscriber());
	}

}
