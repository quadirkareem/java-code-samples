
public class SortedArray {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 10, 20, 2 };
		System.out.println("Array is sorted: " + isArraySorted(arr, 0));
	}

	private static boolean isArraySorted(int[] arr, int position) {
		System.out.println("arr[" + position + "]=" + arr[position]);
		if(arr.length < 2) {
			return true;
		}
		else if(position == arr.length-2) {
			return arr[position] <= arr[position+1];
		}
		else {
			return (arr[position] <= arr[position+1]) && (isArraySorted(arr, position+1));
		}
	}

}
