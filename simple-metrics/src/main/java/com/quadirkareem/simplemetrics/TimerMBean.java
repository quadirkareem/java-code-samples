package com.quadirkareem.simplemetrics;

import java.util.concurrent.TimeUnit;

public interface TimerMBean {

	public long getCount();
	
	public long getTotal();

	public float getMean();

	public long getMin();

	public long getMax();
	
	public TimeUnit getUnit();
	
	public boolean isEnabled();
}
