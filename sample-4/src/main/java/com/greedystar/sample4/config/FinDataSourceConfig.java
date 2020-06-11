package com.greedystar.sample4.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Author GreedyStar
 * Date   2020-6-11
 */
@Configuration
@MapperScan(basePackages = "com.greedystar.sample4.fin.dao", sqlSessionTemplateRef = "finSqlSessionTemplate")
public class FinDataSourceConfig {

    @Bean(name = "finDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.fin")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Bean(name = "finSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("finDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/fin/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "finTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("finDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "finSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("finSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
