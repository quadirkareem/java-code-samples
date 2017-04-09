package com.ciphercloud.tryouts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestBraceEscapeRegex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(":\".+?\"\\}");
		String s = "{\"value\":\"asdksadkj \\\" ddd \"}";
		Matcher m = p.matcher(s);
		if(m.find()) {
			System.out.println("found " + m.group());
		}
		else {
			System.out.println("Not found");
		}
	}

}
