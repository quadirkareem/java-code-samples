import java.util.HashMap;
import java.util.Map;


public class TestHashMap {

	public static void main(String[] args) {
		Map<MyHashElement, String> map = new HashMap<MyHashElement, String>();
		
		MyHashElement m1 = new MyHashElement(10);
		MyHashElement m2 = new MyHashElement(10);
		map.put(m1, "hello");
		System.out.println(map.get(m1));
		System.out.println(map.get(m2));
	}

}

class MyHashElement {
	int value;
	
	MyHashElement(int v) {
		value = v;
	}
	
	//@Override
	public boolean equals(Object o) {
		return value == ((MyHashElement) o).value;
	}
	
	public int hashCode() {
		return value;
	}
}