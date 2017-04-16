package com.quadirkareem.tryouts;
import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class CharArrIndexOf {

    @Test
    public void testAllNull() {
        Assert.assertEquals(-1, indexOf(null, null));
    }

    @Test
    public void testStringNull() {
        Assert.assertEquals(-1, indexOf(null, "hello".toCharArray()));
    }

    @Test
    public void testSubstringNull() {
        Assert.assertEquals(-1, indexOf("hello".toCharArray(), null));
    }

    @Test
    public void testAllEmpty() {
        Assert.assertEquals(-1, indexOf("".toCharArray(), "".toCharArray()));
    }

    @Test
    public void testStringEmpty() {
        Assert.assertEquals(-1, indexOf("".toCharArray(), "hello".toCharArray()));
    }

    @Test
    public void testSubstringEmpty() {
        Assert.assertEquals(-1, indexOf("hello".toCharArray(), "".toCharArray()));
    }

    @Test
    public void testFind() {
        Assert.assertEquals(1, indexOf("hello".toCharArray(), "ell".toCharArray()));
    }

    @Test
    public void testNoFind() {
        Assert.assertEquals(-1, indexOf("hello".toCharArray(), "elt".toCharArray()));
    }

    @Test
    public void testSameStrings() {
        Assert.assertEquals(0, indexOf("hello".toCharArray(), "hello".toCharArray()));
    }

    @Test
    public void testFindLongerSubstring() {
        Assert.assertEquals(-1, indexOf("hello".toCharArray(), "hellot".toCharArray()));
    }

    @Test
    public void testFindAtStart() {
        Assert.assertEquals(0, indexOf("hello".toCharArray(), "h".toCharArray()));
    }

    @Test
    public void testFindAtEnd() {
        Assert.assertEquals(4, indexOf("hello".toCharArray(), "o".toCharArray()));
    }

    @Test
    public void testFindInBetween() {
        Assert.assertEquals(2, indexOf("hello".toCharArray(), "l".toCharArray()));
    }

    @Test
    public void testFindTillEnd() {
        Assert.assertEquals(1, indexOf("hello".toCharArray(), "ello".toCharArray()));
    }

    @Test
    public void testNoFindAtEnd() {
        Assert.assertEquals(-1, indexOf("hello".toCharArray(), "lot".toCharArray()));
    }

    @Test
    public void testFindRepeater() {
        Assert.assertEquals(4, indexOf("hellhellot".toCharArray(), "hellot".toCharArray()));
    }

    @Test
    public void testFindRepeater2() {
        Assert.assertEquals(6, indexOf("hello hellot".toCharArray(), "hellot".toCharArray()));
    }

    // Ben Kessler
    // int indexOf(char needle[], char haiStack[]) {
    int findFirstIndexOf(char needle[], char haiStack[]) {
        int matchIndex = 0;
        int searchIndex = 0;

        // While no full match and not reached end of string...
        while (matchIndex < needle.length && searchIndex < haiStack.length) {
            if (haiStack[searchIndex] == needle[matchIndex]) {
                // Matching
                matchIndex++;
            }
            else if (haiStack[searchIndex] == needle[0]) {
                // Restart, the first character already matches!
                matchIndex = 1;
            }
            else {
                // Restart
                matchIndex = 0;
            }
            searchIndex++;
        }

        return matchIndex == needle.length ? searchIndex - needle.length : -1;
    }

    // Ulrich
    // int indexOf(char[] a, char[] b) {
    int getIndexOfString(char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[0]) {
                if (Arrays.equals(b, Arrays.copyOfRange(a, i, i + b.length))) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Andrew Glassman
    // int indexOf(char[] toSearch, char[] toFind) {
    int find(char[] toSearch, char[] toFind) {
        return IntStream.range(0, toSearch.length).filter(i -> {
            for (int j = 0; j < toFind.length; j++) {
                if (toSearch[i + j] != toFind[j]) {
                    return false;
                }
            }
            return true;
        }).findAny().orElse(-1);
    }

    // Franklin Neves
    // int indexOf(char[] originalString, char[] targetString) {
    public int findIndexOf(char[] originalString, char[] targetString) {
        for (int start = 0; start < originalString.length; start++) {
            int limit = targetString.length - 1;
            if ((originalString[start] == targetString[0]) && (originalString[start + limit] == targetString[limit])) {
                for (int temp = 1; temp <= limit; temp++) {
                    if (originalString[start + temp] != targetString[temp]) {
                        start += limit;
                        break;
                    }
                    if (temp == limit) {
                        return start;
                    }
                }
            }
        }
        return -1;
    }

    // Alberto Gonzalez
    // int indexOf(char[] s, char[] t) {
    int f(char[] s, char[] t) {
        int i = 0, j = 0, l = s.length;
        for (; i <= t.length - l; i++)
            for (j = 0;; j++) {
                if (s[j] != t[j + i])
                    break;
                if (j == l - 1)
                    return i;
            }
        return -1;
    }

    // Alejandro Robledo
    // int f(char[] s, char[] f) {
    int indexOfAlejandro(char[] s, char[] f) {
        int i = 0, j = 0;
        for (; i < s.length; i++)
            for (j = 0;; j++) {
                if ((s[i + j] ^ f[j]) != 0)
                    break;
                if (j == f.length - 1)
                    return i;
            }
        return -1;
    }

    // Nunya Business
    int indexOf(char[] srcChar, char[] sc) {
        int[] fa = new int[sc.length];
        boolean[] testcase = new boolean[sc.length];
        int ci = 0;
        int subLen = sc.length;
        boolean found = true;
        for (char c : srcChar) {
            for (int i = 0; i < subLen; i++) {
                if (c == sc[i]) {
                    fa[i] = ci;
                }
                if (i >= subLen - 1) {
                    for (int j = 0; j < subLen - 1; j++) {
                        if ((fa[i] == fa[i - 1] + (i - 1))) {
                            testcase[j] = true;
                        }
                    }
                    for (boolean tc : testcase) {
                        if (!tc) {
                            found = false;
                        }
                    }
                    if (found) {
                        break;
                    }
                }
            }
            ci++;
        }
        return fa[0];
    }

    // Don Lewis
    int f(char[] s, int j, char[] t, int l) {
        int i, n, x, z = -1, m = l;
        for (i = 0; i < j + 1; i++) {
            n = 0;
            for (x = i; x < i + l; x++) {
                m = s[x] == t[n++] ? i : z;
            }
            if (m > z)
                return i;
        }
        return z;
    }

}
