package com.merce.password;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;

/**
 * create by pengchuan.chen on 2019/06/03.
 */
public class AesUtils {

  //默认字符集
  private static final String DEFAULT_CARSET = "UTF-8";
  //加密方式
  private static final String AES = "AES";
  //使用的加密算法
  private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";
  //密钥 (需要前端和后端保持一致)
  private static final String KEY = "infoaeskey123456";
  //加密结果转换成多少进制的字符串
  private static final int RADIX = 16;

  /**
   * aes解密
   *
   * @param encrypt 内容
   * @return
   * @throws Exception
   */
  public static String aesDecrypt(String encrypt) {
    try {
      return aesDecrypt(encrypt, KEY);
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * aes加密
   *
   * @param content
   * @return
   * @throws Exception
   */
  public static String aesEncrypt(String content) {
    try {
      return aesEncrypt(content, KEY);
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * AES加密
   *
   * @param content    待加密的内容
   * @param encryptKey 加密密钥
   * @return 加密后的byte[]
   * @throws Exception
   */
  private static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
    KeyGenerator kgen = KeyGenerator.getInstance(AES);
    kgen.init(128);
    Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
    cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), AES));

    return cipher.doFinal(content.getBytes(DEFAULT_CARSET));
  }


  /**
   * AES加密为十六进制
   *
   * @param content    待加密的内容
   * @param encryptKey 加密密钥
   * @return 加密后的base 64 code
   * @throws Exception
   */
  public static String aesEncrypt(String content, String encryptKey) throws Exception {
    byte[] encodArroy = aesEncryptToBytes(content, encryptKey);
    return byteToString(encodArroy, RADIX);
  }

  /**
   * AES解密
   *
   * @param encryptBytes 待解密的byte[]
   * @param decryptKey   解密密钥
   * @return 解密后的String
   * @throws Exception
   */
  public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
    KeyGenerator kgen = KeyGenerator.getInstance(AES);
    kgen.init(128);

    Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), AES));
    byte[] decryptBytes = cipher.doFinal(encryptBytes);
    return new String(decryptBytes);
  }


  /**
   * 解密字符串
   *
   * @param encryptStr 需要解密的字符串
   * @param decryptKey 解密秘钥
   * @return
   * @throws Exception
   */
  public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
    return (encryptStr != null && encryptStr.length() > 0) ? aesDecryptByBytes(stringToByte(encryptStr, RADIX), decryptKey) : null;
  }

  /**
   * 将byte[]转为各种进制的字符串
   *
   * @param bytes byte[]
   * @param radix 可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
   * @return 转换后的字符串
   */
  private static String byteToString(byte[] bytes, int radix) {
    return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
  }

  /**
   * 将指定进制的字符串转换成byte数组
   *
   * @param hexStr
   * @param radix  指定是多少进制，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
   * @return
   */
  public static byte[] stringToByte(String hexStr, int radix) {
    if (hexStr.length() < 1)
      return null;
    byte[] result = new byte[hexStr.length() / 2];
    for (int i = 0; i < hexStr.length() / 2; i++) {
      int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), radix);
      int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), radix);
      result[i] = (byte) (high * 16 + low);
    }
    return result;
  }

  //TEST
  public static void main(String[] args) throws Exception {
    if(args != null && args.length == 2){
      String action = args[0].trim();
      String word = args[1].trim();

      if(word.length() == 0){
        System.out.println("Parameters error!");
      }else {

        if ("-e".equalsIgnoreCase(action)) {
          System.out.println("AES encrypt result is " + aesEncrypt(word));
        } else if ("-d".equalsIgnoreCase(action)) {
          System.out.println("AES decode result is " + aesDecrypt(word));
        } else {
          System.out.println("Parameters error!");
        }
      }

    }else{
      System.out.println("Parameters error!");
    }

//
//    String content = "admin";
//    System.out.println("加密前：" + content);
//    System.out.println("加密密钥和解密密钥：" + KEY);
//    String encrypt = aesEncrypt(content);
//    System.out.println("加密后：" + encrypt);
//    String decrypt = aesDecrypt(encrypt);
//    System.out.println("解密后：" + decrypt);
  }
}
