package com.ciphercloud.tryouts;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TestStringBytes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub`
		/*for(byte i = -128; i <= 127; i++) {
			byte[] b = new byte[] { i };
			System.out.println(i + " = " + new String(b, StandardCharsets.UTF_8));
		}*/
		String[] s  = { "1000000", "0111000", "0101010" };
		for(String s1 : s) {
			byte b = Byte.parseByte(s1, 2);
			byte[] bar = { b };
			System.out.println(b + " = " + new String(bar, StandardCharsets.UTF_8));
		}
		
		Boolean bool = Boolean.valueOf("TRUE");
		System.out.println(bool);
//		System.out.println(Arrays.toString("大日本帝國".getBytes(StandardCharsets.UTF_8)));
	}

}
