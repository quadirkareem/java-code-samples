package com.quadirkareem.dsa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringGenerator {

	private static Map<Character, Integer> positions;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] charr = { 'a', 'b', 'c', 'd', 'e' };

		// System.out.println(Arrays.copyOfRange(charr, 0, 5));
		List<String> substrings = generateSubstrings(charr);
		substrings.stream().forEach(System.out::println);
		System.out.println(substrings.size());
		// computePositions(charr);
		// List<String> permutations = generatePermutationsXOrder(charr,
		// charr.length);
		// List<String> permutations = generatePermutationsX(charr,
		// charr.length);
		// List<String> permutations = generatePermutations(charr,
		// charr.length);
		// permutations.stream().forEach(System.out::println);
		// System.out.println(permutations.size());
	}

	private static List<String> generateSubstrings(char[] charr) {
		List<String> substrings = new ArrayList<String>();
		for (int i = 0; i < charr.length; i++) {
			for (int j = i; j <= charr.length; j++) {
				if (i != j) {
					substrings.add(Arrays.asList(Arrays.copyOfRange(charr, i, j)).stream().map(x -> String.valueOf(x))
							.collect(Collectors.joining()));
				}
			}
		}
		return substrings;
	}

	private static List<String> generatePermutationsXOrder(char[] charr, int size) {
		List<String> permutations = new ArrayList<String>();
		if (size == 1) {
			for (int i = 0; i < charr.length; i++) {
				permutations.add(String.valueOf(charr[i]));
			}
		} else {
			List<String> tempList = generatePermutationsXOrder(charr, size - 1);
			permutations.addAll(tempList);
			for (int i = 0; i < charr.length; i++) {
				for (int j = 0; j < tempList.size(); j++) {
					String s = tempList.get(j);
					if (s.length() == size - 1 && !s.contains(String.valueOf(charr[i]))) {
						if (isOrdered(charr[i], s)) {
							permutations.add(charr[i] + s);
						}
					}
				}
			}
		}
		return permutations;
	}

	private static void computePositions(char[] charr) {
		positions = new HashMap<Character, Integer>();
		for (int i = 0; i < charr.length; i++) {
			positions.put(charr[i], i);
		}
	}

	private static boolean isOrdered(char c, String s) {
		return positions.get(c) < positions.get(s.charAt(0));
	}

	private static List<String> generatePermutationsX(char[] charr, int size) {
		List<String> permutations = new ArrayList<String>();
		if (size == 1) {
			for (int i = 0; i < charr.length; i++) {
				permutations.add(String.valueOf(charr[i]));
			}
		} else {
			List<String> tempList = generatePermutationsX(charr, size - 1);
			permutations.addAll(tempList);
			for (int i = 0; i < charr.length; i++) {
				for (int j = 0; j < tempList.size(); j++) {
					String s = tempList.get(j);
					if (s.length() == size - 1 && !s.contains(String.valueOf(charr[i]))) {
						permutations.add(charr[i] + s);
					}
				}
			}
		}
		return permutations;
	}

	private static List<String> generatePermutations(char[] charr, int size) {
		List<String> permutations = new ArrayList<String>();
		if (size == 1) {
			for (int i = 0; i < charr.length; i++) {
				permutations.add(String.valueOf(charr[i]));
			}
		} else {
			List<String> tempList = generatePermutations(charr, size - 1);
			for (int i = 0; i < charr.length; i++) {
				for (int j = 0; j < tempList.size(); j++) {
					String s = tempList.get(j);
					if (!s.contains(String.valueOf(charr[i]))) {
						permutations.add(charr[i] + s);
					}
				}
			}
		}
		return permutations;
	}

}
