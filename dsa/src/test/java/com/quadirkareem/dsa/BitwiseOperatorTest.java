package com.quadirkareem.dsa;

import java.util.function.BiFunction;

import org.junit.Test;

public class BitwiseOperatorTest {

	// @Test
	public void testBitwise() {
		System.out.println("\n==== testBitwise ====");
		int x = 54;
		System.out.println(x + "=" + Integer.toBinaryString(x));
		System.out.println("\n--- Left Shift ---");
		for (int i = 0; i <= 5; i++) {
			int j = x << i;
			int k = (int) (x * Math.pow(2, i));
			System.out.println(x + "<<" + i + " ==> " + k + "; " + j + " [" + Integer.toBinaryString(j) + "]");
		}

		System.out.println("\n--- Right Shift ---");
		for (int i = 0; i <= 8; i++) {
			int j = x >> i;
			int k = (int) (x * Math.pow(2, -i));
			System.out.println(x + ">>" + i + " ==> " + k + "; " + j + " [" + Integer.toBinaryString(j) + "]");
		}

		System.out.println("\n--- Right Shift 2 ---");
		for (int i = 0; i <= 5; i++) {
			int j = x >>> i;
			System.out.println(x + ">>>" + i + " ==> " + j + " [" + Integer.toBinaryString(j) + "]");
		}

		System.out.println("\n--- Complement ---");
		for (int i = 0; i <= 5; i++) {
			int j = ~i;
			int k = -i - 1;
			System.out.println("~" + i + " ==> " + k + "; " + j + " [" + Integer.toBinaryString(j) + "]");
		}
	}

	@Test
	public void testBitwiseLogical() {
		System.out.println("\n==== testBitwiseLogical ====");
		int x = 54;
		System.out.println(x + "=" + Integer.toBinaryString(x));
		runFunction((a, b) -> a & b, "AND", " & ", x);
		x = 55;
		System.out.println(x + "=" + Integer.toBinaryString(x));
		runFunction((a, b) -> a & b, "AND", " & ", x);

		// runFunction( (int a) -> x | a, "OR", " | ", x);
		// runFunction( (int a) -> x ^ a, "XOR", " ^ ", x);
	}

	private void runFunction(BiFunction<Integer, Integer, Integer> oper, String name, String symbol, int x) {
		final int MAX = 10;
		System.out.println("\n--- " + name + " ---");
		int y = oper.apply(x, x);
		System.out.println(x + symbol + x + " ==> " + y + " [" + Integer.toBinaryString(y) + "]");
		for (int i = 0; i <= MAX; i++) {
			y = oper.apply(x, i);
			System.out.println(x + symbol + i + " ==> " + y + " [" + Integer.toBinaryString(y) + "]");
		}
	}

	// @Test
	public void testBitwiseNegative() {
		System.out.println("\n==== testBitwiseNegative ====");
		for (int i = -1; i >= -10; i--) {
			System.out.println(i + ": ");
			// x<<y ==> x * 2^y
			System.out.println("Left Shift: " + (i << 1) + ", " + (i << 2) + ", " + (i << 3) + ", " + (i << i));

			System.out.println("Right Shift: " + (i >> 1) + ", " + (i >> 2) + ", " + (i >> 3) + ", " + (i >> i));
			System.out.println("Right Shift 2: " + (i >>> 1) + ", " + (i >>> 2) + ", " + (i >>> 3));
			// ~x ==> -x-1
			System.out.println("Complement: " + ~i);
		}
	}

}
