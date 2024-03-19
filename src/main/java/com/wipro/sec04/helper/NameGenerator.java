package com.wipro.sec04.helper;

import java.util.ArrayList;
import java.util.List;

import com.wipro.common.Util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class NameGenerator {
	private static final List<String> names = new ArrayList<>();

	public static Flux<String> generate() {
		
		return Flux.generate(sink -> {
			Util.sleep(1);
			log.info("Generating fresh names");
			String name = Util.faker()
					.name()
					.firstName();
			names.add(name);
			sink.next(name);
		})
				.startWith(getFromCache())
				.cast(String.class);
	}

	private static Flux<String> getFromCache() {
		return Flux.fromIterable(names);
	}

}
