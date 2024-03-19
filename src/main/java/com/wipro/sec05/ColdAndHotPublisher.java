package com.wipro.sec05;

import java.time.Duration;
import java.util.stream.Stream;

import com.wipro.common.Util;

import reactor.core.publisher.Flux;

public class ColdAndHotPublisher {
	public static void main(String[] args) {
		// Cold - Netflix
		// Hot - MUlticast - Cinema Hall
		// share -> publish() + refCount()
		Flux<String> movieStream = Flux.fromStream(() -> showMovies())
				.delayElements(Duration.ofSeconds(1))
				.publish()
				.refCount(2);

		movieStream.subscribe(Util.subscriber("Krishna"));
		
		Util.sleep(5);
		
		movieStream.subscribe(Util.subscriber("Ram"));

		Util.sleep(50);
	}

	private static Stream<String> showMovies() {
		return Stream.of("Scene 1", "Scene 2", "Scene 3", "Scene 4", "Scene 5", "Scene 6");
	}

}
