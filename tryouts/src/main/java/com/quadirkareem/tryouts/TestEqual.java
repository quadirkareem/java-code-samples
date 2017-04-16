package com.quadirkareem.tryouts;
import java.util.Random;

import com.ciphercloud.tryouts.metrics.Command;
import com.ciphercloud.tryouts.metrics.Timer;


public class TestEqual {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		long now = System.currentTimeMillis();
		Random r = new Random(now);
		int one = r.nextInt();
		int two = r.nextInt();
		System.out.println("one = " + one + ", two = " + two);
		int count = 100000;
		
		runBenchmarks(100, one, two);
		System.out.println("\nTOTAL TIME");
		runBenchmarks(count, one, two);
	}
	
	private static void runBenchmarks(int count, int one, int two) {
		System.out.println("Count, Equals 1, Equals 2");
		
		Timer t1 = new Timer(count, new Equals1Command(one, two));
		t1.measure();

		Timer t2 = new Timer(count, new Equals2Command(one, two));
		t2.measure();

		System.out.println(count + ", " + t1.getTotalTime() + ", " + t2.getTotalTime());
	}
	


}

abstract class AbstractEqualsCommand implements Command {
	int x;
	int y;
	
	public AbstractEqualsCommand(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

class Equals1Command extends AbstractEqualsCommand {
	
	public Equals1Command(int x, int y) {
		super(x, y);
	}

	@Override
	public void run() {
		//boolean b = (x == y);
	}
	
}

class Equals2Command extends AbstractEqualsCommand {
	
	public Equals2Command(int x, int y) {
		super(x, y);
	}

	@Override
	public void run() {
		//boolean b = !(x < y) && !(x > y);
	}
	
}
