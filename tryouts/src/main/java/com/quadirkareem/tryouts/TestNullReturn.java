package com.quadirkareem.tryouts;

public class TestNullReturn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hello());
	}

	
	public static String hello() {
		Object o = null;
		return (String) o;
	}
}
