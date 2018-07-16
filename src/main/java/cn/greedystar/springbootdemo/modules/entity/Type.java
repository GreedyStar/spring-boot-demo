package cn.greedystar.springbootdemo.modules.entity;

import cn.greedystar.springbootdemo.common.BaseEntity;

/**
 * Author GreedyStar
 * Date   2018/7/13
 */
public class Type extends BaseEntity {
    private String name;

    public Type() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
