package com.quadirkareem.tryouts;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class TestTagIndex {

	private static final String HTML_FILE = "src/main/resources/test.html";

	public static void main(String[] args) throws IOException {
//		Integer ss = null;
//		Object o = ss;
//		String s = (String) o;
		
		String tag = "</HTML>";
		String htmlBody = FileUtils.readFileToString(new File(HTML_FILE), StandardCharsets.UTF_8);
		int tagIndex = -1;
		long startTime = 0;
		long timeTaken = 0;

		for (int i = 0; i < 10; i++) {
			tagIndex = indexOfIgnoreCase(htmlBody, tag);
			tagIndex = indexOfIgnoreCaseCharArr(htmlBody, tag);
			tagIndex = getTagIndex(htmlBody, tag);
			tagIndex = StringUtils.indexOfIgnoreCase(htmlBody, tag);
			tagIndex = getLowerCaseTagIndex(htmlBody, tag);
			tagIndex = indexOfRegex(htmlBody, tag);
		}

		for (int i = 0; i < 100; i++) {
			startTime = System.currentTimeMillis();
			tagIndex = indexOfIgnoreCase(htmlBody, tag);
			timeTaken = System.currentTimeMillis() - startTime;
			System.out.println("indexOfIgnoreCase: " + tagIndex + " ("
					+ timeTaken + " ms)");
			
			startTime = System.currentTimeMillis();
			tagIndex = indexOfIgnoreCaseCharArr(htmlBody, tag);
			timeTaken = System.currentTimeMillis() - startTime;
			System.out.println("indexOfIgnoreCaseCharArr: " + tagIndex + " ("
					+ timeTaken + " ms)");

			startTime = System.currentTimeMillis();
			tagIndex = indexOfRegex(htmlBody, tag);
			timeTaken = System.currentTimeMillis() - startTime;
			System.out.println("indexOfRegex: " + tagIndex + " (" + timeTaken
					+ " ms)");

			startTime = System.currentTimeMillis();
			tagIndex = getTagIndex(htmlBody, tag);
			timeTaken = System.currentTimeMillis() - startTime;
			System.out.println("getTagIndex: " + tagIndex + " (" + timeTaken
					+ " ms)");

			startTime = System.currentTimeMillis();
			tagIndex = getLowerCaseTagIndex(htmlBody, tag);
			timeTaken = System.currentTimeMillis() - startTime;
			System.out.println("getLowerCaseTagIndex: " + tagIndex + " ("
					+ timeTaken + " ms)");

			startTime = System.currentTimeMillis();
			tagIndex = StringUtils.indexOfIgnoreCase(htmlBody, tag);
			System.out.println("StringUtils.indexOfIgnoreCase: " + tagIndex
					+ " (" + timeTaken + " ms)");

			System.out.println("===");
		}
	}

	private static int indexOfRegex(String str, String searchStr) {
		Matcher m = Pattern.compile(searchStr, Pattern.CASE_INSENSITIVE)
				.matcher(str);
		if (m.find()) {
			return m.start();
		} else {
			return -1;
		}
	}

	private static int getLowerCaseTagIndex(String htmlBody, String tag) {
		tag = tag.toLowerCase();
		htmlBody = htmlBody.toLowerCase();
		return htmlBody.indexOf(tag);
	}

	private static int indexOfIgnoreCaseCharArr(String str, String searchStr) {
		int index = -1;
		int searchStrLength = searchStr.length();
		int strLength = str.length();
		if (str != null && searchStr != null && searchStrLength > 0
				&& strLength >= searchStrLength) {
			int endLimit = strLength - searchStrLength + 1;
			searchStr = searchStr.toLowerCase();
			char lower = searchStr.charAt(0);
			char upper = searchStr.toUpperCase().charAt(0);
			int fromIndex = 0;

			char[] chars = str.toCharArray();
			for (int i = 0; i <= endLimit; i++) {
				if (chars[i] == upper || chars[i] == lower) {
					fromIndex = i + searchStrLength;
					String substr = new String(Arrays.copyOfRange(chars, i,
							fromIndex)).toLowerCase();
					if (substr.equals(searchStr)) {
						index = i;
						break;
					}
				}
			}
		}

		return index;
	}

	private static int getTagIndex(String htmlBody, String tag) {
		int tagIndex = -1;
		tag = tag.toLowerCase();
		if (tag != null && htmlBody != null && tag.length() > 2
				&& htmlBody.length() >= tag.length()) {
			if (tag.charAt(0) == '<') {
				int fromIndex = 0;
				do {
					tagIndex = htmlBody.indexOf('<', fromIndex);
					if (tagIndex > -1) {
						fromIndex = tagIndex + tag.length();
						if (fromIndex <= htmlBody.length()) {
							String tagInHtmlBody = htmlBody.substring(tagIndex,
									fromIndex).toLowerCase();
							if (tagInHtmlBody.equals(tag)) {
								break;
							}
						} else {
							tagIndex = -1;
							break;
						}
					} else {
						break;
					}
				} while (true);
			}
		}

		return tagIndex;
	}

	private static int indexOfIgnoreCase(String str, String searchStr) {
		int index = -1;
		if (str != null && searchStr != null && searchStr.length() > 0
				&& str.length() >= searchStr.length()) {
			int fromIndex = 0;
			int upperIndex = -1;
			int lowerIndex = -1;
			searchStr = searchStr.toLowerCase();
			char lower = searchStr.charAt(0);
			char upper = String.valueOf(lower).toUpperCase().charAt(0);
			int searchStrLength = searchStr.length();
			int endLimit = str.length() - searchStrLength + 1;
			do {
				index++;
				lowerIndex = str.indexOf(upper, index);
				upperIndex = str.indexOf(lower, index);
				if(lowerIndex < 0) {
					index = upperIndex;
				}
				else if(upperIndex < 0) {
					index = lowerIndex;
				}
				else if(lowerIndex < upperIndex) {
					index = lowerIndex;
				}
				else {
					index = upperIndex;
				}
				if (index > -1 && index <= endLimit) {
					fromIndex = index + searchStrLength;
					String substr = str.substring(index, fromIndex)
							.toLowerCase();
					if (substr.equals(searchStr)) {
						break;
					}
				} else {
					index = -1;
					break;
				}
			} while (true);
		}

		return index;
	}
}
