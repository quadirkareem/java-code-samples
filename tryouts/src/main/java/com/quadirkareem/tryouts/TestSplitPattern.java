package com.quadirkareem.tryouts;
import java.util.Arrays;
import java.util.regex.Pattern;


public class TestSplitPattern {
	
	static final String users = "qkareemullah, nsmohammad,hchintamreddy\r\ndnaramreddy;sadjlk"; 
	static final Pattern p = Pattern.compile("(?s)[,;\\s]\\s*");
	
	public static void main(String[] args) {
		String[] u = p.split(users);
		System.out.println(Arrays.toString(u));
	}

}
