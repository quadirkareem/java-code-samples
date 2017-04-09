package com.ciphercloud.tryouts.metrics;


public class Timer {
	
	private int count;
	private Command command;
	private int totalTime = 0;
	private int avgTime = 0;
	private int minTime = Integer.MAX_VALUE;
	private int maxTime = 0;

	public Timer(int count, Command command) {
		this.count = count;
		this.command = command;
	}
	
	public void measure() {
		long start = 0;
		long end = 0;
		int delta = 0;

		for (int i = 0; i < count; i++) {
			start = System.currentTimeMillis();
			command.run();
			end = System.currentTimeMillis();
			delta = (int) (end - start);
			totalTime += delta;
			if (maxTime < delta) {
				maxTime = delta;
			}
			if (minTime > delta) {
				minTime = delta;
			}
		}
		
		avgTime = totalTime/count;
	}
	
	@Override
	public String toString() {
		return "Command: ".concat(command.toString()).concat("\n")
				.concat("Count = " + count).concat("\n") 
				.concat("Total Time = " + totalTime).concat(" ms\n")
				.concat("Avg Time = " + avgTime).concat(" ms\n")
				.concat("Max Time = " + maxTime).concat(" ms\n")
				.concat("Min Time = " + minTime).concat(" ms\n")
				;
	}

	public int getCount() {
		return count;
	}

	public Command getCommand() {
		return command;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public int getAvgTime() {
		return avgTime;
	}

	public int getMinTime() {
		return minTime;
	}

	public int getMaxTime() {
		return maxTime;
	}

}
