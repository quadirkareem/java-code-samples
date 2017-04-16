package com.quadirkareem.tryouts;
import com.ciphercloud.tryouts.metrics.Command;
import com.ciphercloud.tryouts.metrics.Timer;

public class TestIfVsException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int runCount = 1000000;
		int loopCount = 1000000;

		runBenchmarks(1000, loopCount);
		System.out.println("\nTOTAL TIME");
		runBenchmarks(runCount, loopCount);

	}

	private static void runBenchmarks(int runCount, int loopCount) {
		System.out.println("Count, If, Exception");
		
		for(int i = 0; i < 20; i++) {
		Timer t1 = new Timer(runCount, new IfCommand(loopCount));
		t1.measure();

		Timer t2 = new Timer(runCount, new ExceptionCommand(loopCount));
		t2.measure();

		System.out.println(runCount + ", " + t1.getTotalTime() + ", "
				+ t2.getTotalTime());
		}
	}

}

abstract class AbstractIfExceptionCommand implements Command {
	protected int count;

	public AbstractIfExceptionCommand(int count) {
		this.count = count;
	}

	protected char getChar(int i) {
		if(i < count) {
			return 'c';
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
}

class IfCommand extends AbstractIfExceptionCommand {

	public IfCommand(int count) {
		super(count);
	}

	@Override
	public void run() {
		char c = '\0';
		for (int i = 0; i < count; i++) {
			if (i + 1 < count) {
				c = getChar(i);
			} else {
				c = '\0';
			}
		}
	}

}

class ExceptionCommand extends AbstractIfExceptionCommand {

	public ExceptionCommand(int count) {
		super(count);
	}

	@Override
	public void run() {
		char c = '\0';
		for (int i = 0; i < count; i++) {
			try {
				c = getChar(i);
			} catch (Exception e) {
				c = '\0';
			}
		}
	}

}