package com.ciphercloud.simplemetrics;

import java.util.concurrent.atomic.AtomicLong;

public class Counter implements Metric, CounterMBean {

	private final String name;
	private final boolean enabled;
	private AtomicLong count;

	public Counter(final String name, final boolean enabled) {
		this.name = name;
		count = new AtomicLong();
		this.enabled = enabled;
	}

	public Counter(final String name) {
		this(name, true);
	}

	public void inc() {
		if (enabled) {
			inc(1);
		}
	}

	public void inc(long n) {
		if (enabled) {
			count.getAndAdd(n);
		}
	}

	public void dec() {
		if (enabled) {
			dec(1);
		}
	}

	public void dec(long n) {
		if (enabled) {
			count.getAndAdd(0 - n);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("type=");
		sb.append(this.getClass().getSimpleName().toUpperCase());
		sb.append(", name=");
		sb.append(name);
		if (enabled) {
			sb.append(", count=");
			sb.append(count.get());
		}
		sb.append(", enabled=");
		sb.append(enabled);
		
		return sb.toString();
	}

	@Override
	public AtomicLong getCount() {
		return count;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
}
