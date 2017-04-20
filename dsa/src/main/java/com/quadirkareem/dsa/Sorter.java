package com.quadirkareem.dsa;

public interface Sorter {

	<T extends Comparable<T>> T[] sort(T[] t);

	<T extends Comparable<T>> T[] sort(T[] t, SortOrder order);

}
