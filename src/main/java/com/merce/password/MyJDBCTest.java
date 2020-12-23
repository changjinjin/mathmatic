package com.merce.password;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
import java.util.*;

public class MyJDBCTest {
    private static Logger logger = LoggerFactory.getLogger(MyJDBCTest.class);

    public static void main(String[] args) throws FileNotFoundException{
        String datasetName="";
        List<Map<String, Object>> myList = null;
        if(args != null && args.length == 1){
            datasetName = args[0].trim();
        }else{
            System.out.println("Parameters error!");
            return;
        }
        if (datasetName.length() == 0) {
            System.out.println("Parameters error!");
            return;
        }else{
            myList = getStepDescListByName(datasetName);
        }
        if(null != myList){
            for(int i = 0; i < myList.size(); i++) {
                Map<String, Object> map = myList.get(i);
                System.out.println(map.get("name"));
            }
            System.out.println("共计查询到的数量为："+ myList.size());
        }else{
            System.out.println("未查询到数据");
        }
    }

    public static List<Map<String,Object>> getStepDescListByName(String datasetName) throws FileNotFoundException{
        InputStream inp=new BufferedInputStream(new FileInputStream(new File("../conf/database.properties")));
        Properties pro=new Properties();
        try {
            pro.load(inp);
        }catch (Exception ex){
            throw new RuntimeException(ex+"读取配置文件失败！");
        }

        String url = pro.getProperty("Url");
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
        String driverClass = pro.getProperty("Driver.class");

        Connection conn=null;
        PreparedStatement pstmt1=null;
        ResultSet newrs = null;
        List<Map<String,Object>> list = new ArrayList();

        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, username, password);
            pstmt1 = conn.prepareStatement("select * from merce_flow");
            newrs= pstmt1.executeQuery();
            while(newrs.next()){
                Map<String,Object> map= new HashMap();
                String steps = newrs.getString("steps");
                if(steps == null || steps.equals("")){
                    //不做任何操作，开始下一次循环
                }else{
                    //解密
                    String uncompressString = null;
                    boolean b = steps.startsWith("[{");
                    if(b == true){
                        uncompressString = steps;
                    }else{
                        uncompressString = GZBase64Utils.uncompressString(steps);
                    }
                    //json字符串转成对象
                    JSONArray jsonArray = JSONArray.parseArray(uncompressString);
                    //循环出现次数
                    int size = jsonArray.size();
                    //只循环一次
                    if(jsonArray.size() == 1){
                        Object o = jsonArray.get(0);
                        String str = o.toString();
                        Map maps = (Map) JSON.parse(str);
                        String type = (String)maps.get("type");

                        if(type.equals("source") || type.equals("sink") || type.equals("cache")){
                            //判断dataset与datasetName是否相同
                            Object otherConfigurations_new = maps.get("otherConfigurations");
                            if(null != otherConfigurations_new){
                                Map map_new = (Map)JSON.parse(otherConfigurations_new.toString());
                                String dataset = (String)map_new.get("dataset");
                                //对dataset判断
                                if(null == dataset || "".equals(dataset)){
                                    //不执行任何操作
                                }else{
                                    dataset = dataset.trim();
                                    if(dataset.equals(datasetName)){
                                        map.put("name", newrs.getString("name"));
                                        list.add(map);
                                    }
                                }
                            }
                        }
                    }
                    //循环多次
                    if(jsonArray.size() > 1){
                        //外层循环列表次数
                        for(int i = 0; i < size; i++){
                            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                            Map maps = (Map)JSON.parse(jsonObject.toString());
                            String type = (String)maps.get("type");

                            if(type.equals("source") || type.equals("sink") || type.equals("cache")){
                                //判断dataset与datasetName是否相同
                                Object otherConfigurations_new = maps.get("otherConfigurations");
                                if(null != otherConfigurations_new){
                                    Map map_new = (Map) JSON.parse(otherConfigurations_new.toString());
                                    String dataset = (String)map_new.get("dataset");
                                    //对dataset判断
                                    if(null == dataset || "".equals(dataset)){
                                        //不执行任何操作
                                    }else{
                                        dataset = dataset.trim();
                                        if(dataset.equals(datasetName)){
                                            map.put("name", newrs.getString("name"));
                                            list.add(map);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (newrs != null){
                try {
                    newrs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (pstmt1 != null){
                try {
                    pstmt1.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}