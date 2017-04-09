package com.ciphercloud.tryouts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TestEqualsIgnoreCase {

	private static final String HTML_FILE = "src/main/resources/test.html";

	public static void main(String[] args) throws IOException {
		String tag = "</HTML>";
		String str1 = FileUtils.readFileToString(new File(HTML_FILE));
		String str2 = FileUtils.readFileToString(new File(HTML_FILE));

		long startTime = 0;
		long t1 = 0;
		long t2 = 0;
		boolean b = false;

		for (int i = 0; i < 10; i++) {
			b = toLowerCase(str1, str2);
			b = equalsIgnoreCase(str1, str2);
		}

		System.out.println("toLowerCase,equalsIgnoreCase");
		for (int i = 0; i < 10; i++) {
			startTime = System.currentTimeMillis();
			b = toLowerCase(str1, str2);
			t1 = System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			b = equalsIgnoreCase(str1, str2);
			t2 = System.currentTimeMillis() - startTime;
			System.out.println(t1 + "," + t2);
		}

	}

	private static boolean toLowerCase(String str1, String str2) {
		str1 = str1.toLowerCase();
		//str2 = str2.toLowerCase();
		return str1.equals(str2);
	}

	private static boolean equalsIgnoreCase(String str1, String str2) {
		return str1.equalsIgnoreCase(str2);
	}

}
