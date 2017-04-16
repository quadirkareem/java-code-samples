package com.quadirkareem.tryouts;

public class TestReplaceIgnoreCase {
	public static void main(String[] args) {
		String a = "Hello There hEllo";
//xHello There hEllo
//012345678901234567	
		System.out.println("=========");
		System.out.println(a);
		
		String b = replaceIgnoreCase(a, "o", "bolo");
		System.out.println("=========");
		System.out.println(b);
		
	}
		
	static String replaceIgnoreCase(String src, String rpl, String rp2) {
		String srcLower = src.toLowerCase();
		String rplLower = rpl.toLowerCase();
		
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int index = srcLower.indexOf(rplLower);
		while(index >= 0) {
			if(index > 0)
				sb.append(src.substring(start, index));
			sb.append(rp2);
			start = index + rplLower.length();
			index = srcLower.indexOf(rplLower, start);
		}
		if(start < src.length())
			sb.append(src.substring(start));
		
		return sb.toString();
	}
}