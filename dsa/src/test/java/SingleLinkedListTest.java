import org.junit.Assert;
import org.junit.Test;

public class SingleLinkedListTest {

	@Test
	public void testAdd() {
		LinkedList<String> l = new SingleLinkedList<String>();
		System.out.println("\n=== testAdd ===");
		System.out.println(l);
		l.add("hello");
		System.out.println(l);
		l.add("bolo");
		System.out.println(l);
		l.add("chalo");
		System.out.println(l);
		l.add("khelo");
		System.out.println(l);
		Assert.assertTrue(l.size() == 4);
	}
	
	@Test
	public void testAddAt() {
		LinkedList<String> l = new SingleLinkedList<String>();
		System.out.println("\n=== testAddAt ===");
		System.out.println(l);
		l.add("hello");
		System.out.println(l);
		l.add("bolo", 1);
		System.out.println(l);
		l.add("chalo", 1);
		System.out.println(l);
		l.add("khelo", 1);
		System.out.println(l);
		Assert.assertTrue(l.size() == 4);
	}
	
	@Test
	public void testMakeEmpty() {
		LinkedList<String> l = new SingleLinkedList<String>();
		System.out.println("\n=== testMakeEmpty ===");
		System.out.println(l);
		l.add("hello");
		System.out.println(l);
		l.remove(0);
		System.out.println(l);
		l.add("bolo");
		System.out.println(l);
		Assert.assertTrue(l.size() == 1);
	}
	
	@Test
	public void testClear() {
		LinkedList<String> l = new SingleLinkedList<String>();
		System.out.println("\n=== testClear ===");
		System.out.println(l);
		l.add("hello");
		System.out.println(l);
		l.remove(0);
		System.out.println(l);
		l.add("bolo");
		System.out.println(l);
		l.add("chalo");
		System.out.println(l);
		l.add("khelo");
		System.out.println(l);
		l.clear();
		System.out.println(l);
		Assert.assertTrue(l.size() == 0);
	}
}
