
public class TestHashCodeIdentity {
	
	public static void main(String[] args) {
		MyHashCode m1 = new MyHashCode(10);
		MyHashCode m2 = new MyHashCode(10);
	
		System.out.println("m1.equals(m2): " + m1.equals(m2));
		System.out.println("m1 == m2: " + (m1 == m2));
		
		System.out.println("m1.equals(m1): " + m1.equals(m1));
		System.out.println("m1 == m1: " + (m1 == m1));

		MyEquals e1 = new MyEquals(10);
		MyEquals e2 = new MyEquals(10);
	
		System.out.println("e1.equals(e2): " + e1.equals(e2));
		System.out.println("e1 == e2: " + (e1 == e2));
		
		System.out.println("e1.equals(e1): " + e1.equals(e1));
		System.out.println("e1 == e1: " + (e1 == e1));

	}

}

class MyHashCode {
	private int value;
	
	public MyHashCode(int value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return this.value;
	}

}

class MyEquals {
	private int value;
	
	public MyEquals(int value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object o) {
		return this.value == ((MyEquals) o).value;
	}

}
