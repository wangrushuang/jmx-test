package com.shuang.notificationOfNotAuto;

import org.springframework.stereotype.Component;

import javax.management.Notification;
import javax.management.NotificationListener;

@Component
public class HelloListener implements NotificationListener {

    @Override
    public void handleNotification(Notification notification, Object handback) {
        System.out.println("监听到消息:"+notification.getMessage());
        if (handback instanceof Hello) {
            Hello hello = (Hello) handback;
            hello.printHello(notification.getMessage());
        }
    }
}
