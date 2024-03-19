package com.wipro.sec06;

import com.wipro.common.Util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class SubPubDemo {
	public static void main(String[] args) {
		// 1 - Subscription always happen in the main/ whichever thread that executes the
		// subscribe method.
		// 2 subscribeOn will be used near the Publisher - publishOn will be used near the subscriber
		Flux<Object> flux = Flux.create(fluxSink -> {
			log.info("Emitting next value");
			fluxSink.next(1);
			Util.sleep(1);
			fluxSink.complete();
		})
				.subscribeOn(Schedulers.boundedElastic());

		flux
		.doOnComplete(()-> log.info("doOnComplete"))
		.publishOn(Schedulers.parallel())
				.doOnRequest(r -> log.info("doOnRequest 1"))
				.doOnNext(val -> log.info("doOnNext 1"))
				
				.subscribe(Util.subscriber());

		Util.sleep(10);

	}

}
