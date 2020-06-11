package com.greedystar.sample3.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.greedystar.sample3.config.jwt.JwtProperty;
import com.greedystar.sample3.config.jwt.JwtUtil;
import com.greedystar.sample3.entity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功Handler
 * <p>
 * Author GreedyStar
 * Date   2020-6-11
 */
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private JwtProperty jwtProperty;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String phone = httpServletRequest.getParameter("username");
        String token = JwtUtil.createToken(phone, jwtProperty);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(new ResponseEntity.Builder().setStatus(200).setData(map).build()));
    }
}
