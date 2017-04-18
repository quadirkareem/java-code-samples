package com.quadirkareem.dsa;

import java.time.Duration;
import java.time.Instant;

public class TowersOfHanoi {

	private static int counter = 0;

	public static void main(String[] args) {
		int n = 40;
		Instant start = Instant.now();
		towersOfHanoi(n, "Src", "Dest", "Aux");
		Instant end = Instant.now();
		System.out.println("Total steps: " + counter);
		System.out.println("Time taken = " + Duration.between(start, end).toMillis() + " milliseconds");
		System.out.println(Math.pow(2, n));
	}

	public static void towersOfHanoi(int n, String src, String dest, String aux) {
		if (n == 1) {
			++counter;
			// System.out.println(++counter + ". Move disk 1 from: " + src + "
			// -> " + dest);
			return;
		}
		// move top n-1 disks from src to aux using dest
		towersOfHanoi(n - 1, src, aux, dest);

		// move nth disk from src to dest
		++counter;
		// System.out.println(++counter + ". Move disk " + n + " from: " + src +
		// " -> " + dest);

		// move n-1 disks from aux to dest using src
		towersOfHanoi(n - 1, aux, dest, src);
	}

}
