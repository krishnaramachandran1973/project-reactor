package com.wipro.common;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class DefaultSubscriber<T> implements Subscriber<T> {
	private String name = "";

	@Override
	public void onSubscribe(Subscription s) {
		log.info(name + " onSubscribe");
		s.request(Long.MAX_VALUE);
	}

	@Override
	public void onNext(T t) {
//		log.info("{}", t.getClass().getName());
		log.info(name + " onNext {}", t);

	}

	@Override
	public void onError(Throwable t) {
		log.error(name + "OnError - {}", t.getMessage());

	}

	@Override
	public void onComplete() {
		log.info(name + " onComplete");

	}

}
