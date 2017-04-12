package com.ciphercloud.simplemetrics;

import java.util.concurrent.TimeUnit;

public class TimerTest {

	static Timer t = new Timer("stopwatch");
	static long total;
	static int count;

	public static void main(String[] args) {
		for(int i = 0; i < 300; i++) {
			System.out.println("");
			hello();
			System.out.println(t);
		}
		

	}
	
	private static void hello() {
		TimerContext tc = t.start();
		long rand = (long) (Math.random() * 50);
		long start = System.nanoTime();
		try {
			long sleep = rand * rand;
			System.out.println("Sleeping for " + sleep + " ms");
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long dur = System.nanoTime() - start;
		total += dur;
		count++;
		System.out.println("count=" + count + ", dur=" + dur + ", total=" + total);
		
		tc.stop();
	}

}
