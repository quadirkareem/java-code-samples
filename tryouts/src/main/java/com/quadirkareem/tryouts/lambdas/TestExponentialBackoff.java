package com.quadirkareem.tryouts.lambdas;

import java.util.Random;
import java.util.function.Predicate;

public class TestExponentialBackoff {

    public static void main(String[] args) {
        TestExponentialBackoff teb = new TestExponentialBackoff();
        
        boolean success = teb.doExponentialBackoffVerification(teb::isActionTaken, "yes");
        System.out.println("Final Result: " + success);
    }
    
    boolean isActionTaken(String s) {
        int random = getRandomNumberInRange(1, 100);
        boolean isEven;
        if(isEven = random % 2 == 0) {
        	System.out.println("isActionTaken: " + isEven + "; random=" + random);
            return true;
        }
        else {
        	System.out.println("isActionTaken: " + isEven + "; random=" + random);
            return false;
        }
    }

//    boolean doExponentialBackoffVerification(Function<String, Boolean> method, String input) {
    boolean doExponentialBackoffVerification(Predicate<String> predicate, String input) {
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
            success = predicate.test(input);
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
    