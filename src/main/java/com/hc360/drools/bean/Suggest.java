package com.hc360.drools.bean;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2019/2/19 11:38
 * @Description:算分优化建议
 */
public class Suggest implements Serializable {

    private Integer index;

    private String desc;

    private String uri;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
