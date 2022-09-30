package com.merce.woven.create.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取原型
 * 设计成单例模式有利于节省系统资源，还可以更方便的管理原型
 *
 * @author ZhengNC
 * @date 2020/7/22 15:44
 */
public class PrototypeCache {
    private Map<Integer, Prototype> cache = new HashMap<>();
    private PrototypeCache(){}
    public static class SingletonHolder{
        private static PrototypeCache INSTANCE = new PrototypeCache();
    }
    public static PrototypeCache getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 根据缓存中的原型获取一个对象
     *
     * @param id
     * @return
     */
    public Prototype getPrototype(Integer id) {
        Prototype p = cache.get(id);
        try {
            return clone(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建一些原型
     */
    public void loadCache(){
        Prototype p1 = new Prototype();
        p1.setId(1);
        p1.setName("p1");
        List<String> list1 = new ArrayList<>();
        list1.add("p1_1");
        list1.add("p1_2");
        list1.add("p1_3");
        p1.setObjs(list1);
        cache.put(p1.getId(), p1);

        Prototype p2 = new Prototype();
        p2.setId(2);
        p2.setName("p2");
        List<String> list2 = new ArrayList<>();
        list2.add("p2_1");
        list2.add("p2_2");
        list2.add("p2_3");
        p2.setObjs(list2);
        cache.put(p2.getId(), p2);
    }

    /**
     * 深克隆对象
     *
     * @param obj
     * @param <T>
     * @return
     */
    private <T extends Serializable> T clone(T obj){
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        T t = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            t = (T)ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bais != null) {
                    bais.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return t;
    }
}
