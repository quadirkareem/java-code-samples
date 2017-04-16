import java.util.concurrent.atomic.AtomicInteger;

public class CircularLinkedList<T> implements LinkedList<T> {

	private AtomicInteger size;
	private Node<T> head;

	public CircularLinkedList() {
		size = new AtomicInteger();
	}

	@Override
	public int size() {
		return size.get();
	}

	@Override
	public T get(int index) {
		Node<T> current = getNode(index);
		if(current != null) {
			return current.item;
		}
		return null;
	}

	private Node<T> getNode(int index) {
		if (index < 0 || index >= size.get()) {
			throw new IllegalArgumentException(
					String.format("Index %d should be greater than 0 or less than List size %d", index, size.get()));
		} else if (index == 0) {
			return head;
		} else if (head != null) {
			Node<T> current = head.next;
			int i = 1;
			while (current != head) {
				if (index == i) {
					break;
				}
				i++;
				current = current.next;
			}
			return current;
		} else {
			return null;
		}
	}

	@Override
	public void add(T item) {
		add(item, size.get());
	}

	@Override
	public void add(T item, int index) {
		Node<T> n = new Node<T>(item, null);
		if (index == 0) {
			n.next = head;
			head = n;
		}
		else {
			Node<T> before = getNode(index-1);
			n.next = before.next;
			before.next = n;
		}
		size.incrementAndGet();
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		head = null;
		size.set(0);
	}

	private static class Node<T> {
		T item;
		Node<T> next;

		Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}

		@Override
		public boolean equals(Object node) {
			if (node instanceof Node<?>) {
				return item.equals(((Node<?>) node).item);
			}
			return false;
		}

		@Override
		public String toString() {
			return item.toString();
		}

	}
}
