package com.quadirkareem.dsa;

abstract class AbstractSort {

	protected <T extends Comparable<T>> boolean isNotOrdered(T x, T y, SortOrder order) {
		return ((order == SortOrder.ASC && x.compareTo(y) > 0) || (order == SortOrder.DESC && x.compareTo(y) < 0));
	}

	protected <T> void swap(T[] arr, int i, int j) {
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
