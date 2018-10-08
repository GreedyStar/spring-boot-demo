/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.greedystar.springbootdemo.common;

import java.util.List;

/**
 * Author GreedyStar
 * Date   2018/7/11
 */
public interface BaseDao<T> {

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public T get(String id);

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    public T get(T entity);

    /**
     * 查询数据列表
     *
     * @param entity
     * @return
     */
    public List<T> findList(T entity);


    /**
     * 查询所有数据列表
     *
     * @return
     */
    public List<T> findAllList();

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    public int insert(T entity);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    public int update(T entity);

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    public int delete(String id);

    /**
     * 删除数据
     *
     * @param entity
     * @return
     */
    public int delete(T entity);

}