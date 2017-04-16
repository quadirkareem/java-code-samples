package com.quadirkareem.tryouts;
public class TestEquality {

	public static void main(String[] args) {
		A a1 = new A(10);
		A a2 = new A(10);
		
		int i = Integer.valueOf(args[0]);
		int j = Integer.valueOf(args[1]);
		Integer i1 = i * 2;
		Integer i2 = j/5;
	
		if(i1 == i2) {
			System.out.println("i1 == i2");
		}
		else {
			System.out.println("i1 != i2");
		}	
	}

    private static class A {
        private int i;
        
        A(int i) {
            this.i = i;
        }
    
    }
        
    
}