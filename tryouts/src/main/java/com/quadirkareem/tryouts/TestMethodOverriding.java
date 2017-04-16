package com.quadirkareem.tryouts;

public class TestMethodOverriding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		B b = new B();
		b.a();
	}
	
}

class A {
	public void a() {
		System.out.println("Parent a");
		b();
	}

	public void b() {
		System.out.println("Parent b");
	}

}

class B extends A {
	@Override
	public void a() {
		System.out.println("Child a");
		super.b();
		super.a();
	}
	
	@Override
	public void b() {
		System.out.println("Child b");
	}
	
}