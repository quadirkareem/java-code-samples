package com.quadirkareem.tryouts;

public class TestIODH {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TestIODH iodh = new TestIODH();
	System.out.println(TestIODH.getField());
	}
	
	public static String getField() {
		return InnerSingleton.hello;
	}
	
	private static class InnerSingleton {
		static String hello = getInstance();
		private static String getInstance() {
			return "hello world";
		}
	}

	
}
