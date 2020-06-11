package com.greedystar.sample2.config.druid;

import com.alibaba.druid.pool.DruidDataSourceStatLogger;
import com.alibaba.druid.pool.DruidDataSourceStatLoggerAdapter;
import com.alibaba.druid.pool.DruidDataSourceStatValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Author GreedyStar
 * Date   2020-6-11
 */
@Component
public class StatLogger extends DruidDataSourceStatLoggerAdapter implements DruidDataSourceStatLogger {
    private Logger logger = LoggerFactory.getLogger(StatLogger.class);

    @Override
    public void log(DruidDataSourceStatValue statValue) {
        logger.info("***************************************************");
        logger.info("                  监控数据持久化                    ");
        logger.info("***************************************************");
    }

}
