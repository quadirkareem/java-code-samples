import com.ciphercloud.tryouts.metrics.Command;
import com.ciphercloud.tryouts.metrics.Timer;

public class TestStringNewVsSBDelete {

	public static void main(String[] args) {
		int count = 100;
		int concatCount = 100000;
		String input = new String("" + System.currentTimeMillis());

		runBenchmarks(5, concatCount, input);
		System.out.println("\nTOTAL TIME");
		runBenchmarks(count, concatCount, input);
	}
	
	private static void runBenchmarks(int count, int concatCount, String input) {
		System.out.println("Count, Delete (ms), New (ms)");
		for (int i = 1; i <= count; i++) {
			Timer t1 = new Timer(count, new SBDeleteCommand(input, concatCount));
			t1.measure();

			Timer t2 = new Timer(count, new SBNewCommand(input, concatCount));
			t2.measure();

			
			System.out.println(concatCount + ", " + t1.getTotalTime() + ", " + t2.getTotalTime());
		}		
		System.out.println("Count, Delete (ms), New (ms)");
	}

}

abstract class AbstractSBCommand implements Command {

	protected int count;
	protected String s;

	public AbstractSBCommand(String s, int count) {
		this.s = s;
		this.count = count;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + ": " + this.count;
	}

}

class SBDeleteCommand extends AbstractSBCommand {

	public SBDeleteCommand(String s, int count) {
		super(s, count);
	}

	@Override
	public void run() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(s);
			sb.delete(0, s.length());
		}
	}
}

class SBNewCommand extends AbstractSBCommand {

	public SBNewCommand(String s, int count) {
		super(s, count);
	}

	@Override
	public void run() {
		StringBuilder sb = null;
		for (int i = 0; i < count; i++) {
			sb = new StringBuilder(s);
		}
	}
}
