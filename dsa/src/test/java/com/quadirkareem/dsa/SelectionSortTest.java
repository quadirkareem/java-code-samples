package com.quadirkareem.dsa;

import org.junit.Test;

public class SelectionSortTest {

	private Sorter sorter = new SelectionSort();

	@Test
	public void testSortDefault() {
		System.out.println("\n=== Asc Order Test ===");
		sorter.sort(ArrayGenerator.generateArray());
	}

	@Test
	public void testSort() {
		System.out.println("\n=== Asc Order Test ===");
		sorter.sort(ArrayGenerator.generateRandomArray());
	}

	@Test
	public void testSortDesc() {
		System.out.println("\n=== Desc Order Test ===");
		Integer[] desc = sorter.sort(ArrayGenerator.generateRandomArray(), SortOrder.DESC);

		System.out.println("\n=== Desc to Asc Order Test ===");
		sorter.sort(desc);
	}

}
