import org.apache.commons.lang3.StringUtils;


public class TestNullInStringUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.replace("hello", "hel", "bo"));
		System.out.println(StringUtils.replace("hello", null, null));
		System.out.println(StringUtils.replace("hello null", null, "goto"));
		System.out.println(StringUtils.replace("hello", "hel", null));
	}

}
