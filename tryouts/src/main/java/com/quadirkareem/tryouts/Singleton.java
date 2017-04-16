package com.quadirkareem.tryouts;

public class Singleton {
	static String hello = getInstance();
	private static String getInstance() {
		return "hello world";
	}
}
