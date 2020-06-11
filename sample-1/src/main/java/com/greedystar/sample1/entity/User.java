package com.greedystar.sample1.entity;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * 用户表
 *
 * Author GreedyStar
 * Date  2020-06-11
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 电话号
     */
    private String phone;
    /**
     * 电子邮箱
     */
    private String email;


    public User(){
    }

    public void setId (int id) {this.id = id;}

    public int getId(){ return id;}

    public void setName (String name) {this.name = name;}

    public String getName(){ return name;}

    public void setPhone (String phone) {this.phone = phone;}

    public String getPhone(){ return phone;}

    public void setEmail (String email) {this.email = email;}

    public String getEmail(){ return email;}


}