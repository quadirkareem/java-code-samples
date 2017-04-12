package com.ciphercloud.simplemetrics;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Metrics {

	private final static ReentrantLock lock = new ReentrantLock();
	private final static Map<String, Metric> metrics = new HashMap<String, Metric>();

	public static Timer timer(final Class<?> klass, final String name) {
		return (Timer) getOrCreate(Timer.class, klass, name,
				TimeUnit.MILLISECONDS, true);
	}

	public static Timer timer(final Class<?> klass, final String name,
			final TimeUnit unit) {
		return (Timer) getOrCreate(Timer.class, klass, name, unit, true);
	}

	public static Timer timer(final Class<?> klass, final String name,
			final boolean enabled) {
		return (Timer) getOrCreate(Timer.class, klass, name,
				TimeUnit.MILLISECONDS, enabled);
	}

	public static Timer timer(final Class<?> klass, final String name,
			final TimeUnit unit, final boolean enabled) {
		return (Timer) getOrCreate(Timer.class, klass, name, unit, enabled);
	}

	public static Counter counter(final Class<?> klass, final String name) {
		return (Counter) getOrCreate(Counter.class, klass, name, null, true);
	}

	public static Counter counter(final Class<?> klass, final String name,
			final boolean enabled) {
		return (Counter) getOrCreate(Counter.class, klass, name, null, enabled);
	}

	public static Metric getOrCreate(final Class<? extends Metric> metricClass,
			final Class<?> klass, final String name, final TimeUnit unit,
			final boolean enabled) throws IllegalArgumentException {
		try {
			lock.lock();
			String metricName = getName(klass, name);
			Metric metric = metrics.get(metricName);

			if (metric != null) {
				return metric;
			} else {
				if (metricClass == Timer.class) {
					metric = new Timer(metricName, unit, enabled);
				} else if (metricClass == Counter.class) {
					metric = new Counter(metricName, enabled);
				} else {
					throw new IllegalArgumentException("Unknown Metric class "
							+ metricClass);
				}

				metrics.put(metricName, metric);

				return metric;
			}
		} finally {
			lock.unlock();
		}
	}

	private static String getName(final Class<?> klass, String name) {
		return klass.getName().concat(".").concat(name);
	}

}
