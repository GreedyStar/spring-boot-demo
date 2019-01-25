package com.greedystar.springbootdemo.modules.web;


import com.greedystar.springbootdemo.common.Response;
import com.greedystar.springbootdemo.modules.entity.User;
import com.greedystar.springbootdemo.modules.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Author GreedyStar
 * Date  2018-07-11
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取所有用户列表", notes = "获取所有用户列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Response getUserList() {
        List<User> userList = userService.findList(new User());
        if (userList == null) {
            return new Response.Builder().setMessage("no data found").setStatus(404).build();
        }
        return new Response.Builder().setMessage("OK").setStatus(200).setData(userList).build();
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Response getUserById(@PathVariable String id) {
        User user = userService.get(id);
        if (user == null) {
            return new Response.Builder().setMessage("no data found").setStatus(404).build();
        }
        return new Response.Builder().setMessage("ok").setStatus(200).setData(user).build();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Response save(@RequestBody User user) {
        if (userService.save(user) == 0) {
            return new Response.Builder().setMessage("save failed").setStatus(9).build();
        }
        return new Response.Builder().setMessage("ok").setStatus(200).setData(user).build();
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Response delete(@RequestBody User user) {
        if (userService.delete(user) == 0) {
            return new Response.Builder().setMessage("delete failed").setStatus(9).build();
        }
        return new Response.Builder().setMessage("ok").setStatus(200).build();
    }
}
