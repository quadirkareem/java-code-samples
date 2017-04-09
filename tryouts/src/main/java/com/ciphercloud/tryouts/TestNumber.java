package com.ciphercloud.tryouts;

public class TestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 16;
		int y  = 16;
		int z = 8;
		
		/*for (int i = 0; i < 50; i += 5) {
			int a = ((i/x) + 1) * y;
			int b = ((i/z) + 1) * y;
			System.out.println(i + " = " + a + "\t\t" + i + " = " + b);
		}*/
		
		int[] arr = { 0, 1, 5, 7, 12, 14, 15, 16, 17, 30, 31, 32, 33, 46, 47, 48, 49, 63, 64, 65, 66 };
		for (int i : arr) {
			int a = ((i/y) * x) - 1;
			int b = ((i/y) * z) - 1;
			System.out.println(i + " = " + a + "\t\t" + i + " = " + b);
		}
		
	}

}
