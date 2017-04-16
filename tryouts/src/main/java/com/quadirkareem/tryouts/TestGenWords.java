package com.quadirkareem.tryouts;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TestGenWords {

	private final static String WORD = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private final static int MAX_LEN = 256;
	private final static String PATH = "src/main/resources/";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//printPlainEncrypted();
		printPlainTextWords();
	}

	private static void massageEncryptedWords() throws IOException {
		String encrypted = FileUtils.readFileToString(new File(PATH
				+ "encrypted.txt"), StandardCharsets.UTF_8);
		String[] encryptedWords = encrypted.split("\\s+");
		StringBuilder sb = new StringBuilder(50000);
		for (int i = 0; i < encryptedWords.length; i++) {
			sb.append(encryptedWords[i]);
			sb.append("\n");
		}
		FileUtils.write(new File(PATH + "finalencryptedtext"), sb,
				StandardCharsets.UTF_8);
	}

	private static void massagePlainWords() throws IOException {
		String encrypted = FileUtils.readFileToString(new File(PATH + "text"),
				StandardCharsets.UTF_8);
		String[] encryptedWords = encrypted.split("\\s+");
		StringBuilder sb = new StringBuilder(50000);
		for (int i = 0; i < encryptedWords.length; i++) {
			sb.append(encryptedWords[i]);
			sb.append("\n");
		}
		FileUtils.write(new File(PATH + "finaltext"), sb,
				StandardCharsets.UTF_8);
	}

	private static void printPlainEncrypted() throws IOException {
		List<String> plainWords = FileUtils.readLines(new File(PATH
				+ "finaltext"), StandardCharsets.UTF_8);
		List<String> encryptedWords = FileUtils.readLines(new File(PATH
				+ "finalencryptedtext"), StandardCharsets.UTF_8);

		StringBuilder sb = new StringBuilder(50000);
		for (int i = 0; i < plainWords.size(); i++) {
			String p = plainWords.get(i);
			String e = encryptedWords.get(i);
			sb.append(p);
			sb.append(",");
			sb.append(e);
			sb.append(",");
			sb.append(p.length());
			sb.append(",");
			sb.append(e.length());
			sb.append("\n");
		}
		FileUtils.write(new File(PATH + "final"), sb,
				StandardCharsets.UTF_8);
	}

	private static void printPlainTextWords() throws IOException {
		StringBuilder sb = new StringBuilder(50000);
		for (int i = 1; i <= MAX_LEN; i++) {
			sb.append(WORD.substring(0, i));
			sb.append(" ");
		}
		FileUtils.write(new File(PATH + "text"), sb);
	}

}
