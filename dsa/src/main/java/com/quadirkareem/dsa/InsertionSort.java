package com.quadirkareem.dsa;

import java.util.Arrays;

public class InsertionSort<T extends Comparable<T>> {

	public T[] sort(T[] arr) {
		return sort(arr, SortOrder.ASC);
	}

	public T[] sort(T[] arr, SortOrder order) {
		for (int i = 1; i < arr.length; i++) {
			addToSortedArray(arr, i, order);
			System.out.println(i + ": " + Arrays.toString(arr));
		}
		return arr;
	}

	private void addToSortedArray(T[] arr, int j, SortOrder order) {
		for (int i = 0; i < j; i++) {
			if (arr[i].compareTo(arr[j]) > 0) {
				slide(arr, i, j);
				break;
			}
		}
	}

	private void slide(T[] arr, int p, int q) {
		T tmp = arr[q];
		for (int i = q - 1; i >= p; i--) {
			arr[i + 1] = arr[i];
		}
		arr[p] = tmp;
	}

}
