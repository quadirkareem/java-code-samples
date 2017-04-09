import java.util.Arrays;


public class TestArraySort {
	
	private static final String[] BUILD_REQUEST_MARKER = {
			"jenkins -t", "jenkins please retest" };
	private static final String[] MERGE_REQUEST_MARKER = {
			"jenkins review complete please merge", "jenkins -m" };
	private static final String[] DECLINE_REQUEST_MARKER = {
			"jenkins please decline", "jenkins -d" };

/*	static {
		Arrays.sort(BUILD_REQUEST_MARKER);
		Arrays.sort(MERGE_REQUEST_MARKER);
		Arrays.sort(DECLINE_REQUEST_MARKER);
	}
*/

	public static void main(String[] args) {
		System.out.println(Arrays.toString(BUILD_REQUEST_MARKER));
		System.out.println(Arrays.binarySearch(BUILD_REQUEST_MARKER, "jenkins -t"));
	}

}
