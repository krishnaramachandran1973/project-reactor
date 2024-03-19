package com.wipro.common;

import java.util.function.Consumer;

import org.reactivestreams.Subscriber;

import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Util {
	private static final Faker FAKER = new Faker();

	public static <T> Consumer<T> onNext() {
		return data -> log.info("Received {}", data);
	}

	public static Consumer<Throwable> onError() {
		return t -> log.error("Error {}", t.getMessage());
	}

	public static Runnable onComplete() {
		return () -> log.info("Completed");
	}

	public static Faker faker() {
		return FAKER;
	}

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static <T> Subscriber<T> subscriber() {
		return new DefaultSubscriber<>();
	}

	public static <T> Subscriber<T> subscriber(String name) {
		return new DefaultSubscriber<>(name);
	}

}
