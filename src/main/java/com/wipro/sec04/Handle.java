package com.wipro.sec04;

import com.wipro.common.Util;

import reactor.core.publisher.Flux;

public class Handle {

	// handle map & filter
	public static void main(String[] args) {
		Flux.range(1, 10)
				.handle((integer, syncSink) -> {
					if (integer % 2 == 0) {
						syncSink.next(integer);
					}

				})
				.subscribe(Util.subscriber());
	}

}
