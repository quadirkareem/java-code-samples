package com.quadirkareem.simplemetrics;

import com.quadirkareem.simplemetrics.Metrics;
import com.quadirkareem.simplemetrics.Timer;
import com.quadirkareem.simplemetrics.TimerContext;

public class MetricsTest {
	
	static private Timer t1 = Metrics.timer(MetricsTest.class, "worker", false);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t = null;
		for (int i = 0; i < 10; i++) {
			t = new Thread(new Worker());
			t.start();
			System.out.println(t1);
		}

		for (int i = 0; i < 100; i++) {
			System.out.println(t1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Timer t1 = Metrics.getTimer("hello");
		// Timer t2 = Metrics.getTimer("hello");

	}
	
	static class Worker implements Runnable {
		private Timer tim = Metrics.timer(MetricsTest.class, "worker");
		
		@Override
		public void run() {
			TimerContext ct = tim.start();
			long rand = (long) (Math.random() * 50);
			try {
				long sleep = rand * rand;
				System.out.println("Thread " + Thread.currentThread().getName() + " sleeping for " + sleep + " ms");
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ct.stop();
		}
		
	}

}
