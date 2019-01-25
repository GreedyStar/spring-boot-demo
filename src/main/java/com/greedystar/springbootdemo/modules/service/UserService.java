package com.greedystar.springbootdemo.modules.service;

import com.greedystar.springbootdemo.common.BaseService;
import com.greedystar.springbootdemo.modules.dao.UserDao;
import com.greedystar.springbootdemo.modules.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author GreedyStar
 * Date  2018-07-11
 */
@Service
@Transactional(readOnly = true)
public class UserService extends BaseService<UserDao, User> {

    public List<User> findUserList(User user) {
        return dao.findUserList(user);
    }

    public User getUserByName(String username) {
        return dao.getByUsername(username);
    }
}
