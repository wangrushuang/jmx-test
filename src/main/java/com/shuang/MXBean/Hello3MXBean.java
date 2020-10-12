package com.shuang.MXBean;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;


@Component
@ManagedResource(objectName = "com.shuang.MXBean:name=Hello3")
public class Hello3MXBean {
    private String name;

    //此种方法无效，貌似必须用接口的形式实现

    @ManagedAttribute(description = "get new name")
    public String getName()
    {
        return name;
    }

    @ManagedAttribute(description = "set new name")
    public void setName(String name)
    {
        this.name = name;
    }

    @ManagedOperation
    public void printHello()
    {
        System.out.println("Hello World, " + name);
    }

    @ManagedOperation
    @ManagedOperationParameter(name = "name", description = "hello name")
    public void printHello(String name)
    {
        System.out.println("Hello , " + name);
    }

    @ManagedAttribute(description = "get user info")
    public User getUser(){
        User user = new User();
        user.setAge(19);
        user.setName("shuang");
        System.out.println("Hello , " + user.getName());
        return user;
    }
}
