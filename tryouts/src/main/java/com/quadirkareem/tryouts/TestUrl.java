package com.quadirkareem.tryouts;

import java.io.File;
import java.net.URI;

public class TestUrl {
	public static void main(String[] args) throws Exception {
		String path = args[0];
		File f = new File(path);
		System.out.println("Absolute Path = " + f.getAbsolutePath());
		System.out.println("Canonical Path = " + f.getCanonicalPath());
		System.out.println("Exists = " + f.exists());
		System.out.println("URI = " + f.toURI());
		System.out.println("URL = " + f.toURI().toURL());
	}
	
	public static void main2(String[] args) throws Exception {
		String uriString = args[0];
		URI uri = new URI(uriString);
		File f = new File(uri);
		System.out.println("Absolute Path = " + f.getAbsolutePath());
		System.out.println("Canonical Path = " + f.getCanonicalPath());
		System.out.println("Exists = " + f.exists());
	}
}