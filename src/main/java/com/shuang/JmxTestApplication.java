package com.shuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;

@EnableMBeanExport // 告诉Spring自动注册MBean,相当于MBeanServer.registerMBean（）
@SpringBootApplication
public class JmxTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmxTestApplication.class, args);
    }

}
