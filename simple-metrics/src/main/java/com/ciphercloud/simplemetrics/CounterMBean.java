package com.ciphercloud.simplemetrics;

import java.util.concurrent.atomic.AtomicLong;

public interface CounterMBean {

	public AtomicLong getCount();
	
	public boolean isEnabled();
}
