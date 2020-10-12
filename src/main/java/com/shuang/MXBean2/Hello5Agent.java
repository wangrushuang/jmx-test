package com.shuang.MXBean2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@RestController
public class Hello5Agent {

    @GetMapping("/hello5")
    public void test() throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("com.shuang.MXBean2:name=Hello5");
        Hello5 hello = new Hello5();
        server.registerMBean(hello, helloName);
        Thread.sleep(500000);
    }

}
