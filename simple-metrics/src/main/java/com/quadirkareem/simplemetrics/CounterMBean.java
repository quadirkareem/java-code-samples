package com.quadirkareem.simplemetrics;

import java.util.concurrent.atomic.AtomicLong;

public interface CounterMBean {

	public AtomicLong getCount();
	
	public boolean isEnabled();
}
