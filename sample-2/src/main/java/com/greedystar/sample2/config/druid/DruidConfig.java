package com.greedystar.sample2.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Author GreedyStar
 * Date   2020-6-11
 */
@Configuration
public class DruidConfig {
    @Autowired
    private StatLogger statLogger;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setStatLogger(statLogger);
        return dataSource;
    }

}
