package com.wipro.sec03;

import java.util.function.Consumer;

import com.wipro.common.Util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.FluxSink;

@Slf4j
public class CountryGenerator implements Consumer<FluxSink<String>> {
	private FluxSink<String> fluxSink;

	@Override
	public void accept(FluxSink<String> t) {
		this.fluxSink = t;
	}

	public void produce() {
		String thread = Thread.currentThread()
				.getName();
		this.fluxSink.next(thread + " " + Util.faker()
				.country()
				.name());
	}

}
