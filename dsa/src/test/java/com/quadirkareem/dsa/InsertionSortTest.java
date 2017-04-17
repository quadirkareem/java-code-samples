package com.quadirkareem.dsa;

import org.junit.Test;

public class InsertionSortTest {

	@Test
	public void testSortDefault() {
		System.out.println("\n=== Asc Order Test ===");
		new InsertionSort<Integer>().sort(ArrayGenerator.generateArray()); 
	}
	
	@Test
	public void testSort() {
		System.out.println("\n=== Asc Order Test ===");
		new InsertionSort<Integer>().sort(ArrayGenerator.generateRandomArray()); 
	}

	@Test
	public void testSortDesc() {
		System.out.println("\n=== Desc Order Test ===");
		new InsertionSort<Integer>().sort(ArrayGenerator.generateRandomArray(), SortOrder.DESC); 
	}

}
