package com.quadirkareem.dsa;

import java.util.Arrays;

public class QuickSort extends AbstractSort implements Sorter {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] arr) {
		return sort(arr, SortOrder.ASC);
	}

	@Override
	public <T extends Comparable<T>> T[] sort(T[] arr, SortOrder order) {
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		partition(arr, 0, arr.length - 1, order);
		return null;
	}

	<T extends Comparable<T>> void partition(T[] arr, int low, int high, SortOrder order) {
		// System.out.println(String.format(": low=%d, high=%d", low, high));
		if (high - low > 1) {
			int pivot = high;
			int q = low;
			for (int i = low; i < pivot; i++) {
				if (arr[i].compareTo(arr[pivot]) <= 0) {
					swap(arr, i, q);
					q++;
				}
			}
			swap(arr, pivot, q);
			pivot = q;
			// System.out.println(String.format("pivot=%d", pivot));
			partition(arr, low, pivot - 1, order);
			partition(arr, pivot + 1, high, order);
		}
		System.out.println(Arrays.toString(arr));
	}

}
