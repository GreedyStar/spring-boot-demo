package com.greedystar.springbootdemo.core.config;

import org.springframework.context.annotation.Configuration;

/**
 * Author GreedyStar
 * Date   2018/7/15
 */
@Configuration
public class DruidConfig {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.druid")
//    public DataSource druidDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setStatLogger(new StatLogger());
//        Properties properties = new Properties();
//        properties.setProperty("config.decrypt", "true");
//        properties.setProperty("config.decrypt.key", "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAI0Q56HOXI2Z33kNpgOxvMbaE7BRUw0pZMLPZA0Pe+J/6R7Cq97BUCDygkzL7evUfQmPprNh6KKaSKXV0dBVghcCAwEAAQ==");
//        dataSource.setConnectProperties(properties);
//        return dataSource;
//    }

//    @Bean
//    public ServletRegistrationBean druidStatViewServlet() {
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        // 白名单
//        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//        // 黑名单
//        servletRegistrationBean.addInitParameter("deny", "192.168.1.100");
//        // 监控平台账号密码
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "admin");
//        // 是否能够重置数据
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        return servletRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean druidWebStatFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }

}
