package com.greedystar.springbootdemo.common;

import com.greedystar.springbootdemo.utils.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.UUID;

/**
 * Author GreedyStar
 * Date   2018/7/11
 */
public class BaseEntity implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    @JsonIgnore
    public boolean isNewRecord() {
        return StringUtil.isBlank(this.id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void preInsert() {
        setId(UUID.randomUUID().toString().replaceAll("-", ""));
    }

}
