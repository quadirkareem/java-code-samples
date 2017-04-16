package com.quadirkareem.tryouts;

public class TestStaticMemberInheritance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParentA c1 = new ChildB();
		c1.printStaticMember();

		ChildB c2 = new ChildB();
		c2.printStaticMember();
		
	}

}


abstract class ParentA {
	
	protected abstract String getStaticMember();
	
	public void printStaticMember() {
		System.out.println("Static Member = " + getStaticMember());
	}

}

class ChildB extends ParentA {
	
	static String staticVar = "assalam alaikum"; 
	
	@Override
	protected String getStaticMember() {
		return staticVar;
	}
	
}