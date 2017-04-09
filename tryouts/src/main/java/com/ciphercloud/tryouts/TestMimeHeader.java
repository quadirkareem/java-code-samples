package com.ciphercloud.tryouts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestMimeHeader {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String filename = "D:\\temp\\babmime.txt";

		String data = readFile(filename);
		if (isMimeContent(data)) {
			System.out.println(filename + " is MIME Content");
		} else {
			System.out.println(filename + " is NOT MIME Content");
		}

	}

	private static boolean isMimeContent(String content) {
		boolean isMime = false;

		int indexOfMimeVersionHeader = content.indexOf("MIME-Version: 1.0");
		int indexOfMimeContentTypeHeader = content.indexOf("Content-Type:");
		int indexOfHtml = content.toLowerCase().indexOf("<html");

		if (indexOfMimeVersionHeader > -1
				&& indexOfMimeContentTypeHeader > -1
				&& (indexOfHtml == -1 || (indexOfMimeVersionHeader < indexOfHtml && indexOfMimeContentTypeHeader < indexOfHtml))) {
			boolean isNewlineBeforeMimeContentTypeHeader = true;
			if (indexOfMimeContentTypeHeader != 0) {
				isNewlineBeforeMimeContentTypeHeader = content
						.charAt(indexOfMimeContentTypeHeader - 1) == '\n';
			}
			boolean isNewlineBeforeMimeVersionHeader = true;
			if (indexOfMimeVersionHeader != 0) {
				isNewlineBeforeMimeVersionHeader = content
						.charAt(indexOfMimeVersionHeader - 1) == '\n';
			}

			if (isNewlineBeforeMimeVersionHeader
					&& isNewlineBeforeMimeContentTypeHeader) {
				isMime = true;
			}
		}

		return isMime;
	}

	private static String readFile(String filename) throws IOException {
		BufferedReader bur = new BufferedReader(new FileReader(filename),
				100000);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = bur.readLine()) != null) {
			sb.append(line + "\n");
		}
		bur.close();

		return sb.toString();
	}
}
