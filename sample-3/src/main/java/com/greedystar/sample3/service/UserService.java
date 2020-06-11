package com.greedystar.sample3.service;

import com.greedystar.sample3.dao.UserDao;
import com.greedystar.sample3.entity.User;

import com.greedystar.sample3.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author GreedyStar
 * Date  2020-06-11
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    public User get(String id) {
        return userDao.get(id);
    }

    public List<User> findList(User user) {
        return userDao.findList(user);
    }

    public List<User> findAllList() {
        return userDao.findAllList();
    }

    public int insert(User user) {
        user.setPassword(new CustomPasswordEncoder().encode("123456789"));
        return userDao.insert(user);
    }

    public int insertBatch(List<User> users) {
        return userDao.insertBatch(users);
    }

    public int update(User user) {
        return userDao.update(user);
    }

    public int delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = userDao.getByPhone(phone);
        if (user == null) {
            throw new UsernameNotFoundException(phone);
        }
        return user;
    }
}
