import java.util.function.DoubleFunction;

public class TestMath {

	public static void main(String[] args) {
		double[] arr = { 2.3, 2.5, 2.7 };
		
		runMethod2( new MathOperator() {
			@Override
			public double apply(double x) {
				return Double.valueOf(Math.floor(x)).intValue();
			}
		}, "Math.floor", arr);
		
		runMethod((double x) -> Double.valueOf(Math.floor(x)).intValue(), "Math.floor", arr);
		runMethod((double x) -> Double.valueOf(Math.ceil(x)).intValue(), "Math.ceil", arr);
		runMethod((double x) -> Long.valueOf(Math.round(x)).intValue(), "Math.round", arr);
		runMethod((double x) -> Double.valueOf(Math.nextDown(x)).intValue(), "Math.nextDown", arr);
		runMethod((double x) -> Double.valueOf(Math.nextUp(x)).intValue(), "Math.nextUp", arr);
		
		System.out.println("\n==============");
		System.out.println("11/2=" + 11/2);
	}

	public static void runMethod(DoubleFunction c, String name, double[] arr) {
		System.out.println("\n==============");
		for (double x : arr)
			System.out.println(String.format("%s(%f)=%d", name, x, c.apply(x)));
	}

	
	public static void runMethod2(MathOperator c, String name, double[] arr) {
		System.out.println("\n==============");
		for (double x : arr)
			System.out.println(String.format("%s(%f)=%d", name, x, c.apply(x)));
	}
	
		
}

interface MathOperator {
	double apply(double x);
}