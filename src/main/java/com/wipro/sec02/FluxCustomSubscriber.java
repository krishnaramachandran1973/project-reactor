package com.wipro.sec02;

import java.util.concurrent.atomic.AtomicReference;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.wipro.common.Util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

public class FluxCustomSubscriber {
	public static void main(String[] args) {
		AtomicReference<Subscription> atomicReference = new AtomicReference<>();
		Flux.range(1, 10)
				.log()
				.subscribeWith(new CustomSubscriber<Integer>(atomicReference));

		atomicReference.get()
				.request(3);
		Util.sleep(2);
		atomicReference.get()
				.request(3);
		Util.sleep(2);
		atomicReference.get()
				.cancel();
		atomicReference.get()
				.request(3);

	}

}

@Slf4j
class CustomSubscriber<T> implements Subscriber<T> {
	AtomicReference<Subscription> atomicReference;

	public CustomSubscriber(AtomicReference<Subscription> atomicReference) {
		this.atomicReference = atomicReference;
	}

	@Override
	public void onSubscribe(Subscription s) {
		log.info("Subscription received");
		atomicReference.set(s);
	}

	@Override
	public void onNext(T t) {
		log.info("Received {}", t);

	}

	@Override
	public void onError(Throwable t) {
		log.error("Error {}", t.getMessage());

	}

	@Override
	public void onComplete() {
		log.info("Complete");

	}

}