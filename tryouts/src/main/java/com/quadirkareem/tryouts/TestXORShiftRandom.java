package com.quadirkareem.tryouts;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestXORShiftRandom {

	private final static int COUNT = 1000000;

//	private final static Random RANDOM = new Random(System.currentTimeMillis());

//	private final static XORShiftRandom XOR = new XORShiftRandom(
//			System.currentTimeMillis());

	//private final static ThreadLocalRandom TLR = ThreadLocalRandom.current();

	public static void main(String[] args) {
		long rndSum = 0;
		long xorSum = 0;
		long tlrSum = 0;
		for (int i = 0; i < 1000; i++) {
			rndSum += randomMath();
			xorSum += xorShiftRandom();
			tlrSum += threadLocalRandom();
		}

		rndSum = 0;
		xorSum = 0;
		tlrSum = 0;
		for (int i = 0; i < COUNT; i++) {
			 rndSum += randomMath();
			 xorSum += xorShiftRandom();
			tlrSum += threadLocalRandom();
		}
		float rndAvg = rndSum / COUNT;
		float xorAvg = xorSum / COUNT;
		float tlrAvg = tlrSum / COUNT;
		System.out.println("randomMath: " + rndAvg + " nanos");
		System.out.println("xorShiftRandom: " + xorAvg + " nanos");
		System.out.println("threadLocalRandom: " + tlrAvg + " nanos");
		System.out.println(System.currentTimeMillis() + " = " + System.nanoTime());
	}

	private static long randomMath() {
		long start = System.nanoTime();
//		long s = RANDOM.nextLong();
		long interval = System.nanoTime() - start;
		// System.out.println(s + ": " + interval + " nanos");

		return interval;
	}

	private static long xorShiftRandom() {
		long start = System.nanoTime();
//		long s = XOR.nextLong();
		long interval = System.nanoTime() - start;
		// System.out.println(s + ": " + interval + " nanos");

		return interval;
	}

	private static long threadLocalRandom() {
		long start = System.nanoTime();
		int s = Math.abs(ThreadLocalRandom.current().nextInt(1000));
		long interval = System.nanoTime() - start;
		System.out.println(s + ": " + interval + " nanos");

		return interval;
	}
}

class XORShiftRandom extends Random {

	/**
	 * 
	 */
	private static final long serialVersionUID = 999755092304656063L;
	private long seed;

	public XORShiftRandom(long seed) {
		this.seed = seed;
	}

	public long nextRandomLong() {
		seed ^= (seed << 21);
		seed ^= (seed >>> 35);
		seed ^= (seed << 4);
		return seed;
	}
}
