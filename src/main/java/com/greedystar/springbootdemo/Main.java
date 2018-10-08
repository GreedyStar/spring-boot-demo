package com.greedystar.springbootdemo;

import com.greedystar.generator.invoker.SingleInvoker;
import com.greedystar.generator.invoker.base.Invoker;

/**
 * Author GreedyStar
 * Date   2018/10/8
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Invoker invoker = new SingleInvoker.Builder()
                .setDatabase("spring-boot-demo")
                .setUsername("root")
                .setTableName("message")
                .build();
        invoker.execute();
    }

}
