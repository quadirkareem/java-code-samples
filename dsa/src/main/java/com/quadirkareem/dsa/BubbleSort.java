package com.quadirkareem.dsa;

import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

	T[] sort(T[] arr, SortOrder order) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (isNotOrdered(arr[j], arr[j + 1], order)) {
					swap(arr, j, j + 1);
				}
			}
			System.out.println(i + ": " + Arrays.toString(arr));
		}
		return arr;
	}

	T[] sort(T[] arr) {
		return sort(arr, SortOrder.ASC);
	}

	private void swap(T[] arr, int p, int q) {
		T tmp = arr[p];
		arr[p] = arr[q];
		arr[q] = tmp;
	}

}
