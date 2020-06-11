package com.greedystar.sample4.sys.entity;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * 角色表
 *
 * Author GreedyStar
 * Date  2020-06-11
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private int id;
    /**
     * 名称
     */
    private String name;


    public Role(){
    }

    public void setId (int id) {this.id = id;}

    public int getId(){ return id;}

    public void setName (String name) {this.name = name;}

    public String getName(){ return name;}


}