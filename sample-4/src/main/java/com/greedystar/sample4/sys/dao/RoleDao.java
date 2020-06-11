package com.greedystar.sample4.sys.dao;

import com.greedystar.sample4.sys.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author GreedyStar
 * Date  2020-06-11
 */
@Mapper
@Component
public interface RoleDao {

    public Role get(String id);

    public List<Role> findList(Role role);

    public List<Role> findAllList();

    public int insert(Role role);

    public int insertBatch(List<Role> roles);

    public int update(Role role);

    public int delete(Role role);

}