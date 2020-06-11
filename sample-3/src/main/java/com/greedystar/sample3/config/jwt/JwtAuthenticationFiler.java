package com.greedystar.sample3.config.jwt;

import com.alibaba.fastjson.JSON;
import com.greedystar.sample3.entity.ResponseEntity;
import com.greedystar.sample3.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Author GreedyStar
 * Date   2020-6-11
 */
public class JwtAuthenticationFiler extends OncePerRequestFilter {
    private JwtProperty jwtProperty;
    private UserService userService;

    public JwtAuthenticationFiler(JwtProperty jwtProperty, UserService userService) {
        this.jwtProperty = jwtProperty;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        httpServletResponse.setContentType("application/json");
        String authorization = httpServletRequest.getHeader("Authorization");
        // 放行GET请求
        if (httpServletRequest.getMethod().equals(String.valueOf(RequestMethod.GET))) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        if (StringUtils.isEmpty(authorization)) { // 未提供Token
            httpServletResponse.getWriter().write(JSON.toJSONString(new ResponseEntity.Builder().setStatus(403).setMessage("Token not provided").build()));
            return;
        }
        if (!authorization.startsWith("Bearer ")) { // Token格式错误
            httpServletResponse.getWriter().write(JSON.toJSONString(new ResponseEntity.Builder().setStatus(403).setMessage("Token format error").build()));
            return;
        }
        authorization = authorization.replace("Bearer ", "");
        Claims claims = JwtUtil.parseToken(authorization, jwtProperty.getBase64Security());
        if (null == claims) { // Token不可解码
            httpServletResponse.getWriter().write(JSON.toJSONString(new ResponseEntity.Builder().setStatus(403).setMessage("Can't parse token").build()));
            return;
        }
        if (claims.getExpiration().getTime() <= new Date().getTime()) { // Token超时
            httpServletResponse.getWriter().write(JSON.toJSONString(new ResponseEntity.Builder().setStatus(403).setMessage("Token expired").build()));
            return;
        }
        // 再进行一些必要的验证
        if (StringUtils.isEmpty(claims.get("phone"))) {
            httpServletResponse.getWriter().write(JSON.toJSONString(new ResponseEntity.Builder().setStatus(403).setMessage("Invalid token").build()));
            return;
        }
        // 上述验证全部通过后，基于token在security上下文中保存登录状态
        UserDetails userDetails = userService.loadUserByUsername(claims.get("phone").toString());
        if (userDetails != null) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            // 设置为已登录
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
