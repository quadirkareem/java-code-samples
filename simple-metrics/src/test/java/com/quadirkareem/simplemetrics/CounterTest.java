package com.quadirkareem.simplemetrics;

import com.quadirkareem.simplemetrics.Counter;

public class CounterTest {

	static Counter c =  new Counter("hello");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 100; i++) {
			hello();
			System.out.println(c);
		}
	}
	
	public static void hello() {
		c.inc();
		System.out.println("hello world");
	}

}
