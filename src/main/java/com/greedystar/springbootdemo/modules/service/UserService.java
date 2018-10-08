package com.greedystar.springbootdemo.modules.service;

import com.greedystar.springbootdemo.common.BaseService;
import com.greedystar.springbootdemo.modules.dao.UserDao;
import com.greedystar.springbootdemo.modules.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author GreedyStar
 * Date  2018-07-11
 */
@Service
@Transactional(readOnly = true)
public class UserService extends BaseService<UserDao, User> implements UserDetailsService {

    public List<User> findUserList(User user) {
        return dao.findUserList(user);
    }

    public User getUserByName(String username) {
        return dao.getByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
