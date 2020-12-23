package com.merce.password;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: haijun
 * @Date: 2019/5/7 14:53
 */
public class GetPass {
    private static Logger logger = LoggerFactory.getLogger(GetPass.class);

    public static void main(String[] args) {
        test();

        GetPass sender = new GetPass();
        String encryPassw = sender.loadFromFile().getProperty("jasypt.encryptor.password");
        logger.info("jasypt.encryptor.password=" +encryPassw);

        StandardPBEStringEncryptor stringEncryptor = new StandardPBEStringEncryptor();
        stringEncryptor.setAlgorithm("PBEWithMD5AndDES");          // 加密的算法，这个算法是默认的
        stringEncryptor.setPassword(encryPassw);//"fedgjsfsfjsoifwe"       // 加密的密钥,可以自定义,但必须和配置文件中配置的解密密钥一致

        if(args != null && args.length == 2){
            String action = args[0].trim();
            String word = args[1].trim();

            if(word.length() == 0){
                logger.info("Parameters error!");
            }else {

                if ("-e".equalsIgnoreCase(action)) {
                    logger.info("Encode result is " + stringEncryptor.encrypt(word));
                } else if ("-d".equalsIgnoreCase(action)) {
                    logger.info("Decode result is " + stringEncryptor.decrypt(word));
                } else {
                    logger.info("Parameters error!");
                }
            }

        }else{
            logger.info("Parameters error!");
        }

    }


    private static void test(){
        StandardPBEStringEncryptor stringEncryptor = new StandardPBEStringEncryptor();
        stringEncryptor.setAlgorithm("PBEWithMD5AndDES");          // 加密的算法，这个算法是默认的
        stringEncryptor.setPassword("fedgjsfsfjsoifwe"); // 加密的密钥,可以自定义,但必须和配置文件中配置的解密密钥一致
        System.out.println(stringEncryptor.encrypt("hello world1322222222222222222222222222222245143534fdgdgtgrehgvxvsfgwr"));

        System.out.println(stringEncryptor.decrypt("4QgtJMrPtunknpDQ6r0soERxpUd9aixo"));

    }

    public Properties loadFromFile() {
        Properties properties = new Properties();
        try {
//            InputStream inputStream = Sender.class.getClassLoader().getResourceAsStream("kafka.properties");
//            properties.load(inputStream);

            InputStream inputStream = new FileInputStream("../conf/my.properties");
            properties.load(inputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("load properties file failed", e);
        } catch (IOException e) {
            throw new RuntimeException("load properties file failed", e);
        }
        return properties;

    }

}
