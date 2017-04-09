
public class FizzBuzz {

	public static void main(String[] args) {
		for(int i=1; i <= 100; i++) {
			int mod5 = i%5;
			int mod3 = i%3;
			 if(mod5==0 && mod3==0) {
				 System.out.println("FizzBuzz");
			 }
			 else if(mod5 == 0) {
				 System.out.println("Buzz");
			 }
			 else if(mod3 == 0) {
				 System.out.println("Fizz");
			 }
			 else {
				 System.out.println(i);
			 }
		} 
	}
}