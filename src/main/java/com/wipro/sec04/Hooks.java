package com.wipro.sec04;

import java.util.stream.IntStream;

import com.wipro.common.Util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Hooks {
	public static void main(String[] args) {
		Flux.create(fluxSink -> {
			IntStream.rangeClosed(1, 10)
					.forEach(i -> fluxSink.next(i));
			fluxSink.error(new RuntimeException("Oops"));
		})
				.doOnComplete(() -> log.info("doOnComplete"))
				.doFirst(() -> log.info("doFirst 1"))
				.doOnNext(o -> log.info("onNext {}", o))
				.doOnSubscribe(s -> log.info("doOnSubscribe {}", s))
				.doOnRequest(r -> log.info("doOnRequest {}", r))
				.doFirst(() -> log.info("doFirst 2"))
				.doFinally(signal -> log.info("doFinally {}", signal))

				.subscribe(Util.subscriber());

	}

}
