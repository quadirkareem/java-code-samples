package com.ciphercloud.tryouts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.JSONObject;

public class TestEscaping {


	private static String STR = "Subject HTML & JSON ESCAPING ` ~ ! @ # $ % ^ & * ( ) _ - + = { [ } ] \\ | : ; ' \" , < . > / ?    \r\nLINE 2\rLINE 3\nLINE 4";
	
	public static void main(String[] args) {
//		STR = "qaudri \" \" klareem";
		System.out.println(STR);
//		System.out.println("\n" + StringEscapeUtils.escapeHtml3(STR));
		System.out.println("\nHTML4:\n" + StringEscapeUtils.escapeHtml4(STR));
		System.out.println("\nJSON:\n" + JSONObject.escape(STR));
		System.out.println("\nJAVA:\n" + StringEscapeUtils.escapeJava(STR));
		System.out.println("\nJSON:\n" + JSONObject.escape(StringEscapeUtils.unescapeHtml4("&nbsp;")));
		System.out.println("\nJAVA:\n" + StringEscapeUtils.escapeJava(StringEscapeUtils.unescapeHtml4("&nbsp;")));

		System.out.println("\nJSON:\n" + JSONObject.escape(StringEscapeUtils.unescapeHtml4("&nbsp;")));
		System.out.println("\nJAVA:\n" + StringEscapeUtils.escapeJava(StringEscapeUtils.unescapeHtml4("&nbsp;")));
		STR = "P = Q { R } S [ T ] U | V \\ W : X ; Y \" Z ' A < B > C , D . E ? F / G    H";
		STR = "P = Q { R } S [ T ] U | V \\ W : X ; Y \" Z ' A < B > C , D . E ? F / G    H"; 
		//System.out.println(Pattern.compile("\\s+").matcher(STR).replaceAll(" "));
		Matcher m = Pattern.compile("\\s{1,}").matcher(STR);
		while(m.find()) {
			System.out.println(m.group() + ": " + m.start() + ", " + m.end() );
		}
		System.out.println(STR.indexOf('G'));
		System.out.println(STR.indexOf('H'));
	}

}
