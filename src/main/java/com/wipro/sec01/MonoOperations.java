package com.wipro.sec01;

import com.wipro.common.Util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class MonoOperations {
	public static void main(String[] args) {
		Mono<Integer> mono = Mono.just(1);

		mono.subscribe(Util.onNext());
		/*
		 * mono.subscribe(value -> log.info("Received {}", value), t ->
		 * log.error("Error {}", t.getMessage()), () -> log.info("Completed"));
		 */

		mono.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

		Mono.fromSupplier(() -> getName())
				.subscribe(Util.onNext());

		Mono.fromCallable(() -> getName())
				.subscribe(Util.onNext());

		Mono.fromRunnable(() -> log.info(Util.faker()
				.name()
				.fullName()));

		getNameSlowly().subscribeOn(Schedulers.boundedElastic())
				.subscribe(Util.onNext());
		
		Util.sleep(4);
		
		Mono.empty();
	}

	private static String getName() {
		return Util.faker()
				.name()
				.fullName();
	}

	private static Mono<String> getNameSlowly() {
		Util.sleep(2);
		return Mono.fromSupplier(() -> {
			log.info("Generating name");
			return Util.faker()
					.name()
					.fullName();
		});
	}

}
