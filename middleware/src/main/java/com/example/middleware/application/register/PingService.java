package com.example.middleware.application.register;

import org.springframework.stereotype.Service;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

@Service
public class PingService {

	private MeterRegistry meterRegistry;
	
	public PingService(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
	}

	public String getPong() {
		Counter customCounter = meterRegistry.counter("my_custom_counter", "Ping Service", "PingService");
		Timer customTimer = meterRegistry.timer("my_custom_timer");
		customCounter.increment();

		Timer.Sample sample = Timer.start(meterRegistry);

		String pong = "Pong";

		sample.stop(customTimer);
		return pong;
	}
}
