
public class TestFinal {

	final String S;// = "hello";
	
	public TestFinal() {
		S = "chalo";
	}
	
	//static final String X;
	static final String X = "betel";
//	static {
//		X = "ldkj";
//		initStatic();
//	}
	
//	private static void initStatic() {
//		X = "kya dum hai";
//	}
	
	public static void main(String[] args) {
		TestFinal tf = new TestFinal();
		//tf.S = "bolo";
		System.out.println("S = " + tf.S);
		System.out.println("X = " + X);
	}

}
