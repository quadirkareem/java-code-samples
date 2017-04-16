package com.quadirkareem.tryouts;
import com.ciphercloud.tryouts.metrics.Command;
import com.ciphercloud.tryouts.metrics.Timer;

public class TestStringConcat {

	public static void main(String[] args) {
		int count = 100000;
		int concatCount = 20;
		String input = new String("" + System.currentTimeMillis());

		runBenchmarks(1000, concatCount, input);
		System.out.println("\nTOTAL TIME");
		runBenchmarks(100000, concatCount, input);
	}
	
	private static void runBenchmarks(int count, int concatCount, String input) {
		System.out.println("String Count, Plus, Concat, StringBuilder");
		for (int i = 1; i <= concatCount; i++) {
			Timer t1 = new Timer(count, new PlusCommand(input, i));
			t1.measure();

			Timer t2 = new Timer(count, new ConcatCommand(input, i));
			t2.measure();

			Timer t3 = new Timer(count, new SBCommand(input, i));
			t3.measure();
			System.out.println(i + ", " + t1.getTotalTime() + ", " + t2.getTotalTime() + ", " + t3.getTotalTime());
		}		
	}

}

abstract class AbstractStringCommand implements Command {

	protected int count;
	protected String s;

	public AbstractStringCommand(String s, int count) {
		this.s = s;
		this.count = count;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + ": " + this.count;
	}

}

class ConcatCommand extends AbstractStringCommand {

	public ConcatCommand(String s, int count) {
		super(s, count);
	}

	@Override
	public void run() {
		String s1 = "x";
		for (int i = 0; i < count; i++) {
			s1 = s1.concat(s);
		}
	}
}

class PlusCommand extends AbstractStringCommand {

	public PlusCommand(String s, int count) {
		super(s, count);
	}

	@Override
	public void run() {
		String s1 = "x";
		for (int i = 0; i < count; i++) {
			s1 += s;
		}
	}
}

class SBCommand extends AbstractStringCommand {

	public SBCommand(String s, int count) {
		super(s, count);
	}

	@Override
	public void run() {
		StringBuilder sb = new StringBuilder("x");
		for (int i = 0; i < count; i++) {
			sb.append(s);
		}
	}
}