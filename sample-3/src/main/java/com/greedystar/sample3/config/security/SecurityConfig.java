package com.greedystar.sample3.config.security;

import com.greedystar.sample3.config.jwt.JwtAuthenticationFiler;
import com.greedystar.sample3.config.jwt.JwtProperty;
import com.greedystar.sample3.config.security.handler.AuthEntryPoint;
import com.greedystar.sample3.config.security.handler.LoginFailureHandler;
import com.greedystar.sample3.config.security.handler.LoginSuccessHandler;
import com.greedystar.sample3.config.security.handler.LogoutSuccessHandler;
import com.greedystar.sample3.service.UserService;
import com.greedystar.sample3.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author GreedyStar
 * Date   2020-6-11
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginSuccessHandler loginSuccessHandler; // 登录成功处理器
    @Autowired
    private LoginFailureHandler loginFailureHandler; // 登录失败处理器
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler; // 注销成功处理器
    @Autowired
    private AuthEntryPoint authEntryPoint; // 权限认证异常处理器
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperty jwtProperty; // jwt属性

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 密码加密，这里采用了简单的MD5加密，可以根据需要自行配置
        return new CustomPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 配置UserService和密码加密服务
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                // 禁用security默认的session机制
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                /*
                这里对URL添加访问权限控制时需要注意：
                1. hasAuthority要以权限的全称标识，如ROLE_ADMIN，可以自定义权限标识
                2. hasRole要以ROLE_开头，且配置权限控制时要省略ROLE_前缀
                */
//                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/user/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/message/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().loginProcessingUrl("/user/login").successHandler(loginSuccessHandler).failureHandler(loginFailureHandler)
                .and()
                .logout().logoutUrl("/user/logout").logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .exceptionHandling().authenticationEntryPoint(authEntryPoint);
        // 配置jwt验证过滤器，位于用户名密码验证过滤器之后
        httpSecurity.addFilterAfter(new JwtAuthenticationFiler(jwtProperty, userService), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) {
        /* 在这里配置security放行的请求 */
        // 统一静态资源
        web.ignoring().antMatchers("/**/*.gif", "/**/*.png", "/**/*.jpg", "/**/*.html", "/**/*.js", "/**/*.css", "/**/*.ico", "/webjars/**");
        // 注册请求
        web.ignoring().mvcMatchers("/user/signup");
        // 放行GET请求
        web.ignoring().antMatchers(HttpMethod.GET, "/**/***");
    }
}
