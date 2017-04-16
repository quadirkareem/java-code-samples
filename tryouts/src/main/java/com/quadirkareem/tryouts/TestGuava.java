package com.quadirkareem.tryouts;
/**
 * @author CipherCloud
 *
 */
class TestGuava {

	public static void main(String[] args) {
		GuavaCache cache = new GuavaCache();
		for(int j=0; j < 10; j++) {
			for(int i=0; i < 1000; i++) {
				cache.get(String.valueOf(i));
				cache.logSize();
			}
			cache.cleanup();
			System.out.println("Cleaned Up Cache");
			cache.logSize();
		}
		cache.logStats();
 		
	}

}
