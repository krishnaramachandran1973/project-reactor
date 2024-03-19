package com.wipro.sec04;

import com.wipro.common.Util;
import com.wipro.sec04.helper.AirIndia;
import com.wipro.sec04.helper.Emirates;
import com.wipro.sec04.helper.Indigo;

import reactor.core.publisher.Flux;

public class FluxMerge {
	public static void main(String[] args) {
		Flux.merge(AirIndia.getFlights(), Emirates.getFlights(), Indigo.getFlights())
				.subscribe(Util.subscriber());
		
		Util.sleep(10);
	}

}
