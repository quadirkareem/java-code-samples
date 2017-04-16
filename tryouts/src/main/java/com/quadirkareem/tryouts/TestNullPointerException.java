package com.quadirkareem.tryouts;
import java.util.concurrent.*;

public class TestNullPointerException {

	public static void main(String[] args) {
		System.out.println("MAIN Thread: Start");
		ExecutorService exe = Executors.newSingleThreadExecutor();
		exe.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Different Thread: Enter");
				System.out.println("Different Thread: Exit");
				throw new NullPointerException();
			}
		});
		exe.shutdown();
		System.out.println("MAIN Thread: Exit");
	}
	
}