package com.quadirkareem.dsa;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleLinkedList<T> implements LinkedList<T> {

	private Node<T> first;
	private Node<T> last;
	private AtomicInteger size;

	public SingleLinkedList() {
		size = new AtomicInteger();
	}
	
	public int size() {
		return size.get();
	}

	public T get(int i) {
		return getNode(i).item;
	}
	
	public void add(T item) {
		add(item, size.get());
	}

	public void add(T item, int i) {
		Node<T> n = new Node<T>(item, null);
		if (i == 0) {
			n.next = first;
			first = n;
		}
		else {
			Node<T> before = getNode(i-1);
			n.next = before.next;
			before.next = n;
		}
		if(i == size.get()) {
			last = n;
		}
		size.incrementAndGet();
	}
	
	public T remove(int i) {
		T value = null;
		if (first == null) {
			throw new IllegalArgumentException(
					"No elements to remove, List size is 0");

		}
		if (i == 0) {
			value = first.item;
			if(first == last) {
				first = last = null;
			}
			else {
				first = first.next;
			}
		} else {
			Node<T> before = getNode(i - 1);
			Node<T> current = before.next;
			if (last == current) {
				last = before;
			}
			before.next = current.next;
			value = current.item;
		}
		size.decrementAndGet();
		return value;
	}

	public void clear() {
		first = last = null;
		size.set(0);
	}

	@Override
	public String toString() {
		Node<T> current = first;
		StringBuilder str = new StringBuilder("SingleLinkedList [ ");
		while (current != null) {
			str.append(current.item);
			str.append(", ");
			current = current.next;
		}
		str.append("]");
		return str.toString();
	}
	
	private Node<T> getNode(int i) {
		if (i < 0 || i >= size.get()) {
			throw new IllegalArgumentException(
					String.format("Index %d should be greater than 0 or less than List size %d", i, size.get()));
		} else {
			int index = 0;
			Node<T> current = first;
			while (current != null) {
				if (index == i) {
					break;
				}
				current = current.next;
				index++;
			}
			return current;
		}
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
