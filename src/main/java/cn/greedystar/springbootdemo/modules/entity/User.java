package cn.greedystar.springbootdemo.modules.entity;

import cn.greedystar.springbootdemo.common.BaseEntity;

/**
 * Author GreedyStar
 * Date  2018-07-11
 */
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}