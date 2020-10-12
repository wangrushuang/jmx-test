package com.shuang.notificationOfNotAuto;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Component;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

@Component
public class JackMBean extends NotificationBroadcasterSupport {
    private int seq = 0;


    //这里的类Jack不仅实现了MBean接口，还继承了NotificationBroadcasterSupport。jack在这里创建并发送了一个消息包
    @ManagedOperation
    public void hi()
    {
        //创建一个信息包
        Notification notify =
                //通知名称；谁发起的通知；序列号；发起通知时间；发送的消息
                new Notification("jack.hi",this,++seq,System.currentTimeMillis(),"jack");
        sendNotification(notify);
    }

}
