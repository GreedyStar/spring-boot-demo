package cn.greedystar.springbootdemo.core.handler;

import cn.greedystar.springbootdemo.common.Response;
import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author GreedyStar
 * Date   2018/7/20
 */
@Component
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(new Response.Builder().setStatus(200).setMessage("Logout success").build()));
    }
}
