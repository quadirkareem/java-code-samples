package com.quadirkareem.dsa;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {

	public T[] sort(T[] arr) {
		return sort(arr, SortOrder.ASC);
	}

	public T[] sort(T[] arr, SortOrder order) {
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int k = arr.length / 2;
		T[] p = sort(arr, order, 0, k);
		T[] q = sort(arr, order, k, arr.length);
		return merge(p, q, order);
	}

	private T[] merge(T[] p, T[] q, SortOrder order) {
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) Array.newInstance(Comparable.class, p.length + q.length);
		int x = 0, y = 0, j = 0;
		while (x < p.length || y < q.length) {
			if (x >= p.length) {
				arr[j++] = q[y++];
			} else if (y >= q.length) {
				arr[j++] = p[x++];
			} else if (isNotOrdered(p[x], q[y], order)) {
				arr[j++] = p[x++];
			} else {
				arr[j++] = q[y++];
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}

	private T[] sort(T[] arr, SortOrder order, int i, int j) {
		if (j - i > 1) {
			int k = i + ((j - i) / 2);
			// System.out.println(String.format("(%d,%d), (%d, %d)", i, k, k,
			// j));
			return merge(sort(arr, order, i, k), sort(arr, order, k, j), order);
		} else {
			return Arrays.copyOfRange(arr, i, j);
		}
	}

}
