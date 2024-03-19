package com.wipro.sec03;

import java.util.stream.Stream;

import com.wipro.common.Util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxCreate2 {
	public static void main(String[] args) {
		Flux.create(fluxSink -> {
			Stream.iterate(0, i -> i + 1)
					.map(i -> {
						log.info("Generating name");
						return Util.faker()
								.country()
								.name();
					})
					.takeWhile(name -> !fluxSink.isCancelled())
					.forEach(country -> fluxSink.next(country));
			fluxSink.complete();
		})
				.take(3)
				.subscribeWith(Util.subscriber());
	}

}
