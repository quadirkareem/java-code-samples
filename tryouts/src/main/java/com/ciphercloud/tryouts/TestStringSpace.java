package com.ciphercloud.tryouts;

import java.util.regex.*;

public class TestStringSpace {
		public static final String WHITESPACE_REGEX = "\\s+";
		public static final Pattern WHITESPACE_PATTERN = Pattern.compile(
			WHITESPACE_REGEX, Pattern.DOTALL);
		
		public static void main(String[] args) {
			String a = " abc wrei wejwe ewrm ewr ewrmn ewr ";
			
			String[] encryptedWords = WHITESPACE_PATTERN
						.split(a);
			System.out.println(encryptedWords.length);
			
			a = "abc wrei wejwe ewrm ewr ewrmn ewr";
			encryptedWords = WHITESPACE_PATTERN
						.split(a);
			System.out.println(encryptedWords.length);
			
			a = " abc wrei wejwe ewrm ewr ewrmn ewr";
			encryptedWords = WHITESPACE_PATTERN
						.split(a);
			System.out.println(encryptedWords.length);
			
			a = "abc wrei wejwe ewrm ewr ewrmn ewr ";
			encryptedWords = WHITESPACE_PATTERN
						.split(a);
			System.out.println(encryptedWords.length);
		}
}