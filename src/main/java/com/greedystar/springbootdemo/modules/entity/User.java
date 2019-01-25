package com.greedystar.springbootdemo.modules.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.greedystar.springbootdemo.common.BaseEntity;

import java.util.List;

/**
 * Author GreedyStar
 * Date  2018-07-11
 */
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private List<Role> roles; // 从数据库查询出的Role

    public void setUsername(String username) {
        this.username = username;
    }


    public String getUsername() {
        return this.username;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}