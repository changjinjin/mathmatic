package com.merce.password;

import org.apache.commons.io.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZBase64Utils {

    public static final String DEFAULT_ENCODING = "UTF-8";

    public static String uncompressString(String zippedBase64Str) throws IOException {
        String result;
        byte[] bytes = Base64.getDecoder().decode(zippedBase64Str);
        GZIPInputStream zi = null;
        try {
            zi = new GZIPInputStream(new ByteArrayInputStream(bytes));
            result = IOUtils.toString(zi, DEFAULT_ENCODING);
        } finally {
            IOUtils.closeQuietly(zi);
        }
        return result;
    }
   
    public static String compressString(String srcTxt) throws IOException {
	  ByteArrayOutputStream rstBao = new ByteArrayOutputStream(); GZIPOutputStream
	  zos = new GZIPOutputStream(rstBao);
	  zos.write(srcTxt.getBytes(DEFAULT_ENCODING)); IOUtils.closeQuietly(zos);
	  
	  byte[] bytes = rstBao.toByteArray(); return
	  Base64.getEncoder().encodeToString(bytes); 
	}
	 
    public static String test1(String name) throws Exception {
        String uncompressed = compressString(name);
//        System.out.println("uncompressed text length:" + uncompressed.length());
//        System.out.println("uncompressed text: " + uncompressed);
        return uncompressed;
    }

    public static void main(String[] args) throws Exception{
        String s1 = uncompressString("H4sIAAAAAAAAAMWUu07DMBRAvwXPHeJnks4IqQsL3RCq0sQtRnlUtjtUiJUNNlRmBkamioF+T1v4C24SaJO+BySGSM69duJzfK8vb1EaJBI1UaYjqU+lDVTcaZ2iBgpiFRhIfL69zB6e5s+Pi+l9meh2NcRVBOOeknHUHg3yLxirVdqHYCzTvr1GTUoaaKBlqIzKUpgAqWGqbDkqVl4MZAivA62SQI8gGmZJItN8SmCi3u9DKKEneVbLwMq2yjeMue8zwQQXlDgNlHVvZGhbEWq6HHMiMPYp44Rwl3iwZWOyUMHa6Cz/7XmJvEFW7ikb6jBPo7vG0o6yMjGddJhUxNRiP04qoaoaBUgVL/xIL4kMzFDLfV7EPi98zQsTnu95jsM84mIqdnnZoNiqJLIVF/Px+9d4sphOZh+vKx0HC4QeKcICWqSSmogt3Fw4wieErXETHwvMmHAoDAneyV0Q1YEhVEEueqSo+3pzVNviz5iBV6bFpIPUUOZwnP7maTMhoP4pdZlzoAu21H9BazrAu94INQWVyD8bcPGaAep54MXxHHDB8ttoT72vrrOlgLIPcv6rby9qnGsoBQAA");
        System.out.println(s1);
    }
}
