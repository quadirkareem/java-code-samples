package com.quadirkareem.dsa;
import java.util.concurrent.atomic.AtomicInteger;

public class DoubleLinkedList<T> implements LinkedList<T> {

	private Node<T> first;
	private Node<T> last;
	private AtomicInteger size;

	public DoubleLinkedList() {
		size = new AtomicInteger();
	}

	public T get(int i) {
		return getNode(i).item;
	}

	public int size() {
		return size.get();
	}

	public void add(T item) {
		add(item, size.get());
	}

	public void add(T item, int i) {
		Node<T> n = new Node<T>(item, null, null);
		if (i == 0) {
			n.next = first;
			first = n;
		} else {
			Node<T> before = getNode(i - 1);
			if (before != null) {
				n.prev = before;
				Node<T> after = before.next;
				if (after != null) {
					n.next = after;
					after.prev = n;
				}
				before.next = n;
			}
		}
		if (i == size.get()) {
			last = n;
		}
		size.incrementAndGet();
	}

	public T remove(int i) {
		T value = null;
		if (first == null) {
			throw new IllegalArgumentException("No elements to remove, List size is 0");

		}
		if (i == 0) {
			value = first.item;
			if (first == last) {
				first = last = null;
			} else {
				Node<T> second = first.next;
				if (second != null) {
					second.prev = null;
					first = second;
				}
			}
		} else {
			Node<T> current = getNode(i);
			if (current != null) {
				Node<T> before = current.prev;
				Node<T> after = current.next;
				if (before != null) {
					before.next = after;
				}
				if (after != null) {
					after.prev = before;
				}
				if (last == current) {
					last = before;
				}
				value = current.item;
			}
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
		StringBuilder str = new StringBuilder("DoubleLinkedList [ ");
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
			Node<T> current = null;
			if (i < size.get() / 2) {
				int index = 0;
				current = first;
				while (current != null) {
					if (index == i) {
						break;
					}
					current = current.next;
					index++;
				}
			} else {
				int index = size.get() - 1;
				current = last;
				while (current != null) {
					if (index == i) {
						break;
					}
					current = current.prev;
					index--;
				}
			}
			return current;
		}
	}

	private static class Node<T> {
		T item;
		Node<T> prev;
		Node<T> next;

		Node(T item, Node<T> prev, Node<T> next) {
			this.item = item;
			this.prev = prev;
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
