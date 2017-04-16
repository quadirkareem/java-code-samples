package com.quadirkareem.tryouts;
public class MySingleton {

	private static MySingleton mySingleton;

	private MySingleton() { }
	
	public static MySingleton getInstance() {
		if (mySingleton == null) {
			mySingleton = new MySingleton();
		}
		return mySingleton;
	}
}
