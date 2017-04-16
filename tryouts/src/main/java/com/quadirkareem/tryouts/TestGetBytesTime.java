package com.quadirkareem.tryouts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TestGetBytesTime {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String filename = "D:\\temp\\100kb.txt";
		int count = 1000;
		String inputStr = readFile(filename);
		getBytesTimer(count, inputStr, null);

		System.out.println("Charset = ISO_8859_1");
		getBytesTimer(count, inputStr, StandardCharsets.ISO_8859_1);
		System.out.println("Charset = US_ASCII");
		getBytesTimer(count, inputStr, StandardCharsets.US_ASCII);
		System.out.println("Charset = UTF-8");
		getBytesTimer(count, inputStr, StandardCharsets.UTF_8);
		System.out.println("Charset = null");
		getBytesTimer(count, inputStr, null);
	}

	private static void getBytesTimer(int count, String inputStr,
			Charset charset) {
		long start = 0;
		long end = 0;
		int delta = 0;
		int totalDelta = 0;
		byte[] inputBytes = null;
		int max = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < count; i++) {
			if (charset == null) {
				start = System.currentTimeMillis();
				inputBytes = inputStr.getBytes();
				end = System.currentTimeMillis();
			} else {
				start = System.currentTimeMillis();
				inputBytes = inputStr.getBytes(charset);
				end = System.currentTimeMillis();

			}
			delta = (int) (end - start);
			totalDelta += delta;
			if (max < delta) {
				max = delta;
			}
			if (min > delta) {
				min = delta;
			}
		}

		System.out.println("Count = " + count + "; Total Time = " + totalDelta
				+ " ms; Avg Time = " + (totalDelta / count)
				+ " ms; Max Time = " + max + " ms; Min Time = " + min + " ms");

	}

	private static String readFile(String filename) throws IOException {
		BufferedReader bur = new BufferedReader(new FileReader(filename),
				100000);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = bur.readLine()) != null) {
			sb.append(line);
		}
		bur.close();

		return sb.toString();
	}

}
