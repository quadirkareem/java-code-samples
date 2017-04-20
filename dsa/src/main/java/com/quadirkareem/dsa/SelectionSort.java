package com.quadirkareem.dsa;

import java.util.Arrays;

public class SelectionSort extends AbstractSort implements Sorter {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] arr) {
		return sort(arr, SortOrder.ASC);
	}

	@Override
	public <T extends Comparable<T>> T[] sort(T[] arr, SortOrder order) {
		for (int i = 0; i < arr.length; i++) {
			int extIndex = getIndexOfMinMax(arr, i, order);
			if (i != extIndex) {
				swap(arr, i, extIndex);
			}
			System.out.println(i + ": " + Arrays.toString(arr));
		}
		return arr;
	}

	private <T extends Comparable<T>> int getIndexOfMinMax(T[] arr, int j, SortOrder order) {
		int extIndex = j;
		for (int i = j; i < arr.length; i++) {
			if (isNotOrdered(arr[i], arr[extIndex], order)) {
				extIndex = i;
			}
		}
		return extIndex;
	}

}
