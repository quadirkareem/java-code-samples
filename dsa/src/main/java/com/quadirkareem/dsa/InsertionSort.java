package com.quadirkareem.dsa;

import java.util.Arrays;

public class InsertionSort extends AbstractSort implements Sorter {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] arr) {
		return sort(arr, SortOrder.ASC);
	}

	@Override
	public <T extends Comparable<T>> T[] sort(T[] arr, SortOrder order) {
		for (int i = 1; i < arr.length; i++) {
			addToSortedArray(arr, i, order);
			System.out.println(i + ": " + Arrays.toString(arr));
		}
		return arr;
	}

	private <T extends Comparable<T>> void addToSortedArray(T[] arr, int j, SortOrder order) {
		for (int i = 0; i < j; i++) {
			if (isNotOrdered(arr[i], arr[j], order)) {
				slide(arr, i, j);
				break;
			}
		}
	}

	private <T> void slide(T[] arr, int p, int q) {
		T tmp = arr[q];
		for (int i = q - 1; i >= p; i--) {
			arr[i + 1] = arr[i];
		}
		arr[p] = tmp;
	}

}
