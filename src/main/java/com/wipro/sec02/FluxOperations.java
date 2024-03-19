package com.wipro.sec02;

import com.wipro.common.Util;

import reactor.core.publisher.Flux;

public class FluxOperations {
	public static void main(String[] args) {
		/*
		 * Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5); flux.subscribe(Util.onNext());
		 * flux.subscribe(Util.onNext());
		 * 
		 * List<Integer> list = Arrays.asList(1, 2, 3, 4);
		 * 
		 * Flux.fromIterable(list);
		 * 
		 * Stream<Integer> stream = list.stream();
		 * 
		 * Flux.fromStream(stream) .subscribe(Util.onNext());
		 * 
		 * Flux.fromStream(list.stream()) .subscribe(Util.onNext());
		 */
		Flux.range(1, 10)
				.log()
				.map(i -> Util.faker()
						.name()
						.fullName())
				.log()
				.subscribe(Util.onNext());

//		Flux.interval(Duration.ofSeconds(2))
//				.subscribe(Util.onNext());

		Util.sleep(4);

		// Convert Mono to a Flux
	}

}
