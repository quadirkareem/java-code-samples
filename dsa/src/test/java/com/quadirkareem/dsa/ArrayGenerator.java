package com.quadirkareem.dsa;

import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {

	private static int DEFAULT_SIZE = 10;
	private static int DEFAULT_LOWER = 1;
	private static int DEFAULT_HIGHER = 25;

	static Integer[] generateArray() {
		Integer[] a = { 150, 1, 39, 32, 2, 50, 100, 0 };
		printArray(a);
		return a;
	}

	static Integer[] generateRandomArray() {
		Integer[] a = new Random().ints(DEFAULT_SIZE, DEFAULT_LOWER, DEFAULT_HIGHER).boxed().toArray(Integer[]::new);
		printArray(a);
		return a;
	}

	static Integer[] generateRandomArray(int size) {
		Integer[] a = new Random().ints(size, DEFAULT_LOWER, size + DEFAULT_HIGHER).boxed().toArray(Integer[]::new);
		printArray(a);
		return a;
	}

	private static void printArray(Integer[] a) {
		System.out.println(Arrays.toString(a));
		System.out.println("================================\n");
	}

}
