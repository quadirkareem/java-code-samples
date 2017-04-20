package com.quadirkareem.dsa;

import java.lang.reflect.Array;
import java.util.Arrays;

//public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> implements Sorter<T> {

public class MergeSort extends AbstractSort implements Sorter {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] arr) {
		return sort(arr, SortOrder.ASC);
	}

	@Override
	public <T extends Comparable<T>> T[] sort(T[] arr, SortOrder order) {
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int k = arr.length / 2;
		T[] p = sort(arr, order, 0, k);
		T[] q = sort(arr, order, k, arr.length);
		return merge(p, q, order);
	}

	private <T extends Comparable<T>> T[] merge(T[] p, T[] q, SortOrder order) {
		// System.out.println(p[0].getClass());
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) Array.newInstance(p[0].getClass(), p.length + q.length);
		int x = 0, y = 0, j = 0;
		while (x < p.length || y < q.length) {
			if (x >= p.length) {
				arr[j++] = q[y++];
			} else if (y >= q.length) {
				arr[j++] = p[x++];
			} else if (isNotOrdered(q[y], p[x], order)) {
				arr[j++] = p[x++];
			} else {
				arr[j++] = q[y++];
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}

	private <T extends Comparable<T>> T[] sort(T[] arr, SortOrder order, int i, int j) {
		if (j - i > 1) {
			int k = i + ((j - i) / 2);
			return merge(sort(arr, order, i, k), sort(arr, order, k, j), order);
		} else {
			return Arrays.copyOfRange(arr, i, j);
		}
	}

}
