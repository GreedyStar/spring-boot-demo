package cn.greedystar.springbootdemo.core.config;

import cn.greedystar.springbootdemo.core.bean.JwtProperty;
import cn.greedystar.springbootdemo.core.filter.JwtAuthenticationFilter;
import cn.greedystar.springbootdemo.core.handler.AuthEntryPoint;
import cn.greedystar.springbootdemo.core.handler.LoginFailureHandler;
import cn.greedystar.springbootdemo.core.handler.LoginSuccessHandler;
import cn.greedystar.springbootdemo.core.handler.LogoutSuccessHandler;
import cn.greedystar.springbootdemo.modules.service.UserService;
import cn.greedystar.springbootdemo.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Security配置
 * <p>
 * Author GreedyStar
 * Date   2018/7/20
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
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().loginProcessingUrl("/user/login").successHandler(loginSuccessHandler).failureHandler(loginFailureHandler)
                .and()
                .logout().logoutUrl("/user/logout").logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .exceptionHandling().authenticationEntryPoint(authEntryPoint);
        // 配置jwt验证过滤器，位于用户名密码验证过滤器之后
        httpSecurity.addFilterAfter(new JwtAuthenticationFilter(jwtProperty), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        /* 在这里配置security放行的请求 */
        // 统一静态资源
        web.ignoring().antMatchers("/**/*.gif", "/**/*.png", "/**/*.jpg", "/**/*.html", "/**/*.js", "/**/*.css", "/**/*.ico", "/webjars/**");
        // Druid监控平台
        web.ignoring().antMatchers("/druid/**");
        // swagger2
        web.ignoring().antMatchers("/swagger-ui.html*/**");
        web.ignoring().mvcMatchers("/v2/api-docs", "/configuration/security", "swagger-resources");
        // 注册请求
        web.ignoring().mvcMatchers("/user/signup");
    }
}
