package com.ciphercloud.tryouts;

public class TestReplace {
		public static void main(String[] args) {
		String a = "abc\r\nxyz 123\n456\r\n789";
		
		System.out.println("=========");
		System.out.println(a);
		
		a = a.replace("\r\n", " ");
		System.out.println("=========");
		System.out.println(a);
		
		a = a.replace("\r", " ");
		System.out.println("=========");
		System.out.println(a);
	
		a = a.replace("\n", " ");
		System.out.println("=========");
		System.out.println(a);
	}
}