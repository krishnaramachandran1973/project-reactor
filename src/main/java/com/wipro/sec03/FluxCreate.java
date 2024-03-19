package com.wipro.sec03;

import java.util.stream.IntStream;

import com.wipro.common.Util;

import reactor.core.publisher.Flux;

public class FluxCreate {
	public static void main(String[] args) {
		Flux.create(fluxSink -> {
			fluxSink.next(Util.faker()
					.country()
					.name());
			fluxSink.next(Util.faker()
					.country()
					.name());
			fluxSink.next(Util.faker()
					.country()
					.name());
			fluxSink.complete();
			fluxSink.error(new RuntimeException("Error"));
		})
				.subscribeWith(Util.subscriber());

		CountryGenerator countryGenerator = new CountryGenerator();
		Flux.create(countryGenerator)
				.subscribeWith(Util.subscriber());

		IntStream.rangeClosed(1, 10)
				.forEach(i -> new Thread(() -> countryGenerator.produce()).start());
	}

}
