
public class TestInstanceOf {

	public static void main(String[] args) {
		Human bob = new Walkable();
		if (bob instanceof Walkable)
			System.out.println("bob is an instance of a Walkable");
		if (bob instanceof Human)
			System.out.println("bob is an instance of a Human");
		if (bob instanceof Mammal)
			System.out.println("bob is an instance of a Mammal");
		if (bob instanceof Animal)
			System.out.println("bob is an instance of a Animal");
		if (bob instanceof Object)
			System.out.println("bob is an instance of a Object");
	
		System.out.println("\n================\n");
		Human john = null;
		if (john instanceof Human)
			System.out.println("john is an instance of a Human");
		else
			System.out.println("john is NOT an instance of a Human");
		
	}

	private static class Animal {
	}

	private static class Mammal extends Animal {
	}

	private static class Human extends Mammal {
	}

	private static class Walkable extends Human {
	}

}
