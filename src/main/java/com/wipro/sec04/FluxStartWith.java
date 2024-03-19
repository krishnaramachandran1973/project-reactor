package com.wipro.sec04;

import com.wipro.common.Util;
import com.wipro.sec04.helper.NameGenerator;

import lombok.extern.slf4j.Slf4j;

// zip - merge - concat - combineLatest -
@Slf4j
public class FluxStartWith {
	public static void main(String[] args) {
		NameGenerator.generate()
				.take(3)
				.subscribe(Util.subscriber("Krishna"));
		
		NameGenerator.generate()
		.take(4)
		.subscribe(Util.subscriber("Sai"));
		
		NameGenerator.generate()
		.filter(name -> name.startsWith("B"))
		.take(1)
		.subscribe(Util.subscriber("Bhuvaneshwari"));

	}

}
