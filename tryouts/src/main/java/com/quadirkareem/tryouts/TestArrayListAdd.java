package com.quadirkareem.tryouts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestArrayListAdd {
	
	public static void main(String[] args) {
		List<String> original = new ArrayList<String>();
		original.add("hello");
		
		List<String> unmodifiable = Collections.unmodifiableList(original);
		List<String> immutable = new ArrayList<String>(original);
		
		original.add("bolo");
		
		System.out.println("original: " + Arrays.toString(original.toArray()));
		System.out.println("unmodifiable: " + Arrays.toString(unmodifiable.toArray()));
		System.out.println("immutable: " + Arrays.toString(immutable.toArray()));
		
	}
}