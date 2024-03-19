package com.wipro.sec04;

import java.util.function.Function;

import com.wipro.common.Util;
import com.wipro.sec04.helper.User;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

// piece of code to apply in many pipelines - transform
@Slf4j
public class FluxTransform {
	public static void main(String[] args) {
		getPersons().transform(applyFilterMap())
				.subscribe(Util.subscriber());
	}

	private static Flux<User> getPersons() {
		return Flux.range(1, 10)
				.map(User::new);
	}

	private static Function<Flux<User>, Flux<User>> applyFilterMap() {
		return flux -> {
			return flux.filter(u -> u.getAge() > 10)
					.doOnNext(u -> u.setName(u.getName()
							.toUpperCase()));
		};
	}

}
