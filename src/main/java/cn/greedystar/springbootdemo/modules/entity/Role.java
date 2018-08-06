package cn.greedystar.springbootdemo.modules.entity;

import cn.greedystar.springbootdemo.common.BaseEntity;

import java.io.Serializable;

/**
 * Author GreedyStar
 * Date  2018-07-23
 */
public class Role extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public Role() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}