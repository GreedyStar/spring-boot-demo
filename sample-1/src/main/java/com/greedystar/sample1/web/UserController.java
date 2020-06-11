package com.greedystar.sample1.web;

import com.greedystar.sample1.entity.User;
import com.greedystar.sample1.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author GreedyStar
 * Date  2020-06-11
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取所有用户列表", notes = "获取所有用户列表")
    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public Object list() {
        List<User> users = userService.findAllList();
        return users;
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(@RequestParam String id) {
        User user = userService.get(id);
        return user;
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "json", paramType = "body")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody User user) {
        if (userService.insert(user) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "json", paramType = "body")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody User user) {
        if (userService.update(user) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "json", paramType = "body")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody User user) {
        if (userService.delete(user) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}
