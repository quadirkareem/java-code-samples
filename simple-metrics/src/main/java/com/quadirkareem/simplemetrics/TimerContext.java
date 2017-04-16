package com.quadirkareem.simplemetrics;

public class TimerContext {
	
	private final long start;
	private final Timer timer;
	
	public TimerContext(final Timer timer) {
		this.timer = timer;
		if(timer.isEnabled()) {
			start = System.nanoTime();
		}
		else {
			start = 0;
		}
	}
	
	public void stop() {
		if(timer.isEnabled()) {
			timer.update(System.nanoTime() - start);
		}
	}
	
}
