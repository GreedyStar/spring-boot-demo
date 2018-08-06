package cn.greedystar.springbootdemo.modules.web;

import cn.greedystar.springbootdemo.common.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author GreedyStar
 * Date   2018/7/23
 */
@RestController
@RequestMapping(value = "/admin/")
public class AdminController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Response test() {

        return new Response.Builder().setMessage("test").setStatus(200).build();
    }

}
