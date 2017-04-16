package com.quadirkareem.lamdbas;

import java.util.Random;

public class TestExponentialBackoff2V2 implements ActionVerifier {

    public static void main(String[] args) {
    	ActionVerifier teb = new TestExponentialBackoff2V2();
        boolean success = doExponentialBackoffVerification(teb, "Hyd", "Delhi", "Bangalore");
        System.out.println("Final Result: " + success);
    }
    
    @Override
    public boolean verifyActionTaken(String s1, String s2, String s3) {
    	System.out.println("isActionTaken: s1=" + s1 + "; s2=" + s2 + "; s3=" + s3); 
        int random = getRandomNumberInRange(1, 100);
        boolean isEven;
        if(isEven = random % 2 == 0) {
        	System.out.println(isEven + "; random=" + random);
            return true;
        }
        else {
        	System.out.println(isEven + "; random=" + random);
            return false;
        }
    }

//    boolean doExponentialBackoffVerification(Function<String, Boolean> method, String input) {
    static boolean doExponentialBackoffVerification(ActionVerifier av, String s1, String s2, String s3) {
        int maxRetries = 3;
        int retryCount = 0;
        int delayMinutes = 2;
        boolean success = false;
        while(retryCount < maxRetries) {
            try {
				Thread.sleep(retryCount * delayMinutes * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//            success = method.apply(input);
            success = av.verifyActionTaken(s1, s2, s3);
            if(success) {
                break;
            }
            retryCount++;
        }
        return success;
    }
    
    private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
    