package com.quadirkareem.dsa;

public interface LinkedList<T> {

	int size();

	T get(int index);

	void add(T item);

	void add(T item, int index);

	T remove(int index);

	void clear();

}
