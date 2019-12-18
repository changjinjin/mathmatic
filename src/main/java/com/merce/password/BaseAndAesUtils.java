package com.merce.password;

/**
 * @Author: haijun
 * @Date: 2019/12/18 16:27
 */
public class BaseAndAesUtils {
    public static void main(String[] args) throws Exception {
        if (args != null && args.length == 2) {
            String action = args[0].trim();
            String word = args[1].trim();

            if (word.length() == 0) {
                System.out.println("Parameters error!");
            } else {
                if ("-e".equalsIgnoreCase(action)) {
                    String base64 = Base64Util.encode(word.getBytes());
                    String aes = AesUtils.aesEncrypt(base64);
                    System.out.println("After Base64&AES encoding, the result is " + aes );
                } else if ("-d".equalsIgnoreCase(action)) {
                    String aes = AesUtils.aesDecrypt(word);
                    String base64 = Base64Util.decode(aes.getBytes());
                    System.out.println("After Base64&AES decode, the result is " + base64);
                } else {
                    System.out.println("Parameters error!");
                }
            }

        } else {
            System.out.println("Parameters error!");
        }
    }


}
