package cn.greedystar.springbootdemo.core.config;

import cn.greedystar.springbootdemo.core.bean.JwtProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author GreedyStar
 * Date   2018/7/18
 */
@Configuration
public class JwtConfig {

    @Bean
    @ConfigurationProperties(prefix = "jwt.config")
    public JwtProperty jwt() {
        return new JwtProperty();
    }

}
