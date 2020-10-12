package com.shuang.notificationOfNotAuto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@RestController
public class HelloAgent {

    //必须先调用此方法，监听才有效
    @GetMapping("/notification")
    public void test1() throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        //ObjectName中的取名是有一定规范的，格式为：“域名：name=MBean名称”，其中域名和MBean的名称可以任意取。这样定义后，就可以唯一标识我们定义的这个MBean的实现类了
        //通过工厂类获取MBeanServer，用来做MBean的容器
        ObjectName helloName = new ObjectName("com.shuang.notification:name=Hello");
        Hello hello = new Hello();
        //将Hello这个类注入到MBeanServer中，注入需要创建一个ObjectName类
        server.registerMBean(hello, helloName);

        JackMBean jackMBean = new JackMBean();
        server.registerMBean(jackMBean, new ObjectName("com.shuang.notification:name=Jack"));
        //谁监听jack发送的消息
        jackMBean.addNotificationListener(new HelloListener(), null, hello);

        //之所以sleep，是因为jack或hello只属于此方法，方法执行完jack/hello就没了，所以监听不到消息了，可以用自动注解方式实现，参见notification2包下的实现
        Thread.sleep(500000);
    }
}
