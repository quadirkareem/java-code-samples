package com.quadirkareem.tryouts;

public class TestSBSetLength {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(1000);
		sb.append("Before calling setlength");
		System.out.println(sb);
		sb.setLength(0);
		System.out.println("After setlength: <" + sb + ">");
	}

}
