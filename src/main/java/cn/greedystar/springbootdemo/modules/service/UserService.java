package cn.greedystar.springbootdemo.modules.service;

import cn.greedystar.springbootdemo.common.BaseService;
import cn.greedystar.springbootdemo.modules.dao.UserDao;
import cn.greedystar.springbootdemo.modules.entity.User;
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
}
