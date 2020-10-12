package com.shuang.notification2OfAuto;

import org.springframework.stereotype.Component;

import javax.management.Notification;
import javax.management.NotificationListener;

@Component
public class Hello2Listener implements NotificationListener {

    @Override
    public void handleNotification(Notification notification, Object handback) {
        System.out.println("监听到消息:"+notification.getMessage());
        if (handback instanceof Hello2MBean) {
            Hello2MBean hello2 = (Hello2MBean) handback;
            hello2.printHello(notification.getMessage());
        }
    }
}
