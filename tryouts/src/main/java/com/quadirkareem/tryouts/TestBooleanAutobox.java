package com.quadirkareem.tryouts;

public class TestBooleanAutobox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean b = (boolean) getBooleanValue();
		
		Object bObj = getBooleanValue();

		if ((bObj == null || !(boolean) bObj))
			System.out.println(bObj);

//		if ((bObj == null || !(boolean) bObj) || true)
//			System.out.println(bObj);
	}

	public static Object getBooleanValue() {
		return null;//Boolean.TRUE;
	}

}
