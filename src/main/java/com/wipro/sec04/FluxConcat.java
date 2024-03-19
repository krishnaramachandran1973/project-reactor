package com.wipro.sec04;

import com.wipro.common.Util;

import reactor.core.publisher.Flux;

public class FluxConcat {
	public static void main(String[] args) {
		Flux<String> flux1 = Flux.just("a", "b", "c", "d");
		Flux<String> flux2 = Flux.just("e", "f");
		Flux<Object> flux3 = Flux.error(new RuntimeException("Oops"));

		Flux.concatDelayError(flux1, flux3, flux2)
				.subscribe(Util.subscriber());
		
//		flux1.concat(flux2).subscribe(Util.subscriber());
	}

}
