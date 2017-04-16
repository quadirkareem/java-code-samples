package com.quadirkareem.tryouts;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;

public class TestIsNotBlankTime {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println( Charset.defaultCharset().name());
		int count = 1000;
		String[] input = {
				"                              																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
						+ "																																		"
		};//+ "alsdlfskdjlfskd" };
		Command c;
		for (String s : input) {
			System.out.println(s.length() + ": " 
					+ StringUtils.isNotBlank(s) + " ||| "
					+ ((s != null) && (s.trim().length() > 0)));
			c = new IsNotBlankCommand(s);
			System.out.println(c);
			getCommandTime(count, c);

			c = new IsNotNullLengthCommand(s);
			System.out.println(c);
			getCommandTime(count, c);

			System.out.println("\n================================\n");
		}
	}

	private static void getCommandTime(int count, Command c) {
		long start = 0;
		long end = 0;
		int delta = 0;
		int totalDelta = 0;
		int max = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < count; i++) {
			start = System.currentTimeMillis();
			c.run();
			end = System.currentTimeMillis();
			delta = (int) (end - start);
			totalDelta += delta;
			if (max < delta) {
				max = delta;
			}
			if (min > delta) {
				min = delta;
			}
		}

		System.out.println("Count = " + count + "; Total Time = " + totalDelta
				+ " ms; Avg Time = " + (totalDelta / count)
				+ " ms; Max Time = " + max + " ms; Min Time = " + min + " ms");

	}

}

interface Command {
	public void run();
}

abstract class AbstractCommand implements Command {

	protected String s;

	public AbstractCommand(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + ": " + this.s;
	}

}

class IsNotBlankCommand extends AbstractCommand {

	public IsNotBlankCommand(String s) {
		super(s);
	}

	@Override
	public void run() {
		boolean b = StringUtils.isNotBlank(this.s);
	}

}

class IsNotNullLengthCommand extends AbstractCommand {

	public IsNotNullLengthCommand(String s) {
		super(s);
	}

	@Override
	public void run() {
		boolean b = (this.s != null) && (this.s.trim().length() > 0);
	}

}

class IsNotEmptyCommand extends AbstractCommand {

	public IsNotEmptyCommand(String s) {
		super(s);
	}

	@Override
	public void run() {
		boolean b = StringUtils.isNotEmpty(s);
	}

}

