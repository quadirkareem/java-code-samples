package com.quadirkareem.dsa;

import java.util.Arrays;

public class SelectionSort<T extends Comparable<T>> {

	public T[] sort(T[] arr) {
		return sort(arr, SortOrder.ASC);
	}
	
	public T[] sort(T[] arr, SortOrder order) {
		for (int i = 0; i < arr.length; i++) {
			int extIndex = getIndexOfMinMax(arr, i, order);
			if (i != extIndex) {
				swap(arr, i, extIndex);
			}
			System.out.println(i + ": " + Arrays.toString(arr));
		}
		return arr;
	}

	private int getIndexOfMinMax(T[] arr, int j, SortOrder order) {
		int extIndex = j;
		for (int i = j; i < arr.length; i++) {
			if (order == SortOrder.ASC) {
				if ((arr[i].compareTo(arr[extIndex]) < 0)) {
					extIndex = i;
				}
			} else {
				if ((arr[i].compareTo(arr[extIndex]) > 0)) {
					extIndex = i;
				}
			}
		}
		return extIndex;
	}

	private void swap(T[] arr, int p, int q) {
		T tmp = arr[p];
		arr[p] = arr[q];
		arr[q] = tmp;
	}

}
