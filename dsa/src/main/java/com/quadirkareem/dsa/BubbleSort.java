package com.quadirkareem.dsa;

import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> {

	public T[] sort(T[] arr, SortOrder order) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (order == SortOrder.ASC) {
					if ((arr[j].compareTo(arr[j + 1]) > 0)) {
						swap(arr, j, j + 1);
					}
				} else {
					if ((arr[j].compareTo(arr[j + 1]) < 0)) {
						swap(arr, j, j + 1);
					}
				}
			}
			System.out.println(i + ": " + Arrays.toString(arr));
		}
		return arr;
	}

	public T[] sort(T[] arr) {
		return sort(arr, SortOrder.ASC);
	}

	private void swap(T[] arr, int p, int q) {
		T tmp = arr[p];
		arr[p] = arr[q];
		arr[q] = tmp;
	}

}
