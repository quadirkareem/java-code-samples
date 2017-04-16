package com.quadirkareem.simplemetrics;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import javax.management.ObjectName;

public class Timer implements Metric, TimerMBean {

	private ReentrantLock lock = new ReentrantLock();
	private final TimeUnit unit;
	private final String name;
	private final boolean enabled;

	private long total;
	private long count;
	private long min = Long.MAX_VALUE;
	private long max;

	protected Timer(final String name, final TimeUnit unit, final boolean enabled) {
		this.name = name;
		this.unit = unit;
		this.enabled = enabled;
		try {
			ManagementFactory.getPlatformMBeanServer()
					.registerMBean(
							this,
							new ObjectName(
									"com.ciphercloud.simplemetrics:type="
											+ name));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected Timer(final String name) {
		this(name, TimeUnit.MILLISECONDS, true);
	}

	protected Timer(final String name, final TimeUnit unit) {
		this(name, unit, true);
	}

	protected Timer(final String name, final boolean enabled) {
		this(name, TimeUnit.MILLISECONDS, enabled);
	}

	protected void update(long duration) {
		try {
			lock.lock();
			updateCount();
			updateTotal(duration);
			updateMin(duration);
			updateMax(duration);
		} finally {
			lock.unlock();
		}
	}

	protected  void updateCount() {
		count++;
	}

	protected  void updateTotal(long duration) {
		total += duration;
	}

	protected  void updateMax(long duration) {
		if (duration > max) {
			max = duration;
		}
	}

	protected  void updateMin(long duration) {
		if (duration < min) {
			min = duration;
		}
	}

	public TimerContext start() {
		return new TimerContext(this);
	}

	@Override
	public long getCount() {
		return count;
	}

	@Override
	public long getTotal() {
		return unit.convert(total, TimeUnit.NANOSECONDS);
	}

	@Override
	public float getMean() {
		try {
			lock.lock();
			return getTotal() / (count * 1.0f);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public long getMin() {
		return unit.convert(min, TimeUnit.NANOSECONDS);
	}

	@Override
	public long getMax() {
		return unit.convert(max, TimeUnit.NANOSECONDS);
	}

	@Override
	public TimeUnit getUnit() {
		return unit;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public String toString() {
		try {
			lock.lock();

			StringBuilder sb = new StringBuilder();
			sb.append("type=");
			sb.append(this.getClass().getSimpleName().toUpperCase());
			sb.append(", name=");
			sb.append(name);
			if (enabled) {
				sb.append(", count=");
				sb.append(count);
				sb.append(", total=");
				sb.append(getTotal());
				sb.append(", mean=");
				sb.append(getMean());
				sb.append(", min=");
				sb.append(getMin());
				sb.append(", max=");
				sb.append(getMax());
				sb.append(", unit=");
				sb.append(unit.name());
			}
			sb.append(", enabled=");
			sb.append(enabled);
			
			return sb.toString();
		} finally {
			lock.unlock();
		}
	}

}
