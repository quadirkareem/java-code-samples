import org.junit.Assert;
import org.junit.Test;

public class StringIndexOf {

    @Test
    public void testAllNull() {
        Assert.assertEquals(-1, indexOf(null, null));
    }

    @Test
    public void testStringNull() {
        Assert.assertEquals(-1, indexOf(null, "hello"));
    }

    @Test
    public void testSubstringNull() {
        Assert.assertEquals(-1, indexOf("hello", null));
    }

    @Test
    public void testAllEmpty() {
        Assert.assertEquals(-1, indexOf("", ""));
    }

    @Test
    public void testStringEmpty() {
        Assert.assertEquals(-1, indexOf("", "hello"));
    }

    @Test
    public void testSubstringEmpty() {
        Assert.assertEquals(-1, indexOf("hello", ""));
    }

    @Test
    public void testFind() {
        Assert.assertEquals(1, indexOf("hello", "ell"));
    }

    @Test
    public void testNoFind() {
        Assert.assertEquals(-1, indexOf("hello", "elt"));
    }

    @Test
    public void testSameStrings() {
        Assert.assertEquals(0, indexOf("hello", "hello"));
    }

    @Test
    public void testFindLongerSubstring() {
        Assert.assertEquals(-1, indexOf("hello", "hellot"));
    }

    @Test
    public void testFindAtStart() {
        Assert.assertEquals(0, indexOf("hello", "h"));
    }

    @Test
    public void testFindAtEnd() {
        Assert.assertEquals(4, indexOf("hello", "o"));
    }

    @Test
    public void testFindInBetween() {
        Assert.assertEquals(2, indexOf("hello", "l"));
    }

    @Test
    public void testFindTillEnd() {
        Assert.assertEquals(1, indexOf("hello", "ello"));
    }

    @Test
    public void testNoFindAtEnd() {
        Assert.assertEquals(-1, indexOf("hello", "lot"));
    }

    @Test
    public void testFindRepeater() {
        Assert.assertEquals(4, indexOf("hellhellot", "hellot"));
    }

    @Test
    public void testFindRepeater2() {
        Assert.assertEquals(6, indexOf("hello hellot", "hellot"));
    }

    @Test
    public void testFindRussian() {
        Assert.assertEquals(4, indexOf("дивизии", "зии"));
    }

    @Test
    public void testNoFindRussian() {
        Assert.assertEquals(-1, indexOf("дивизии", "дви"));
    }

    int indexOf(String s, String x) {
        return indexOfQuadir2(s, x);
    }

    int indexOfQuadir2(String s, String t) {
        if (s != null && t != null && t.length() > 0) {
            int l = s.length();
            int m = t.length();
            for (int i = 0, j = 0; i < l; i++, j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    if (s.charAt(i) == t.charAt(0))
                        j = 0;
                    else
                        j = -1;
                }
                if (l - i < m - j)
                    return -1;
                if (j == m - 1)
                    return (i - m + 1);
            }
        }
        return -1;
    }

    // Quadir
    int indexOfQuadir(String s, String x) {
        if (s != null && x != null && x.length() > 0) {
            for (int i = 0, j = 0; i < s.length(); i++, j++) {
                if (s.charAt(i) != x.charAt(j)) {
                    if (s.charAt(i) == x.charAt(0))
                        j = 0;
                    else
                        j = -1;
                }
                if (s.length() - i < x.length() - j)
                    return -1;
                if (j == x.length() - 1)
                    return (i - x.length() + 1);
            }
        }
        return -1;
    }

    // Don Lewis
    // int subString(String srcString, String subString){
    int indexOfDonLewis(String srcString, String subString) {
        boolean match = false;
        for (int startSearchIndex = 0; startSearchIndex < srcString.length() - subString.length()
            + 1; startSearchIndex++) {
            int n = 0;
            for (int x = startSearchIndex; x < startSearchIndex + subString.length(); x++) {
                match = srcString.charAt(x) == subString.charAt(n++);
                if (!match)
                    break; // Exit loop as quickly as possible
            }
            if (match)
                return startSearchIndex;
        }
        return -1;
    }

}
