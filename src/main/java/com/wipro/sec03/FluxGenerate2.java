package com.wipro.sec03;

import com.wipro.common.Util;

import reactor.core.publisher.Flux;

public class FluxGenerate2 {
	public static void main(String[] args) {
		Flux.generate(() -> 0, (state, synchronousSink) -> {
			synchronousSink.next(Util.faker()
					.country()
					.name());

			if (state >= 10) {
				synchronousSink.complete();
			}
			return state + 1;
		})
				// .take(3)
				.subscribeWith(Util.subscriber());
	}

}
