package com.merce.woven.create.prototype;

import java.io.Serializable;
import java.util.List;

/**
 * 原型（通常情况下直接创建此类的对象代价很大）
 *
 * @author ZhengNC
 * @date 2020/7/22 15:36
 */
public class Prototype implements Serializable {
    private Integer id;

    private String name;

    private List<String> objs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getObjs() {
        return objs;
    }

    public void setObjs(List<String> objs) {
        this.objs = objs;
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", objs=" + objs +
                '}';
    }
}
