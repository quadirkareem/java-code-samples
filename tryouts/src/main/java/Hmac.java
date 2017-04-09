import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

public class Hmac {
    
    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final String EXPECTED_SIGNATURE = "YqHKymkYh28sBk+Nm5uSk398ajttR0WNZLvOybWSAys=";
    
    public static void main(String[] args) throws Exception {
        System.out.println("Expected Signature: " + EXPECTED_SIGNATURE);
    
        String apiKey = "aoHDWfInYyuDTricC3ne_JinghCniXb7MGXIXjZ_FvOwmtR3";
        String msg = "account=294379";
        String signature = Hmac.getDigest(apiKey, msg);
        System.out.println("Actual Signature: " + signature);
       // System.out.println("Both are same: " + EXPECTED_SIGNATURE.equals(signature));
	}

    public static String getDigest(String keyString, String msg) throws Exception {
		Mac macAlgorithm = Mac.getInstance(HMAC_ALGORITHM);
        macAlgorithm.init(new SecretKeySpec(keyString.getBytes(),HMAC_ALGORITHM) );
        return Base64.getEncoder().encodeToString(macAlgorithm.doFinal(msg.getBytes()));
    }

}
