package com.quadirkareem.dsa;

abstract class AbstractSort<T extends Comparable<T>> {

	protected boolean isNotOrdered(T x, T y, SortOrder order) {
		return ((order == SortOrder.ASC && x.compareTo(y) > 0) || (order == SortOrder.DESC && x.compareTo(y) < 0));
	}
}
