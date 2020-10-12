package com.shuang.MXBean2;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.stereotype.Component;


@Component
public class Hello5 implements Hello5MXBean {
    private String name;

    @ManagedAttribute(description = "get new name")
    @Override
    public String getName()
    {
        return name;
    }

    @ManagedOperation
    @ManagedOperationParameter(name = "name", description = "new name")
    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @ManagedOperation
    @Override
    public void printHello()
    {
        System.out.println("Hello World, " + name);
    }

    @ManagedOperation
    @ManagedOperationParameter(name = "name", description = "hello name")
    @Override
    public void printHello(String name)
    {
        System.out.println("Hello , " + name);
    }

    @ManagedAttribute(description = "get user info")
    @Override
    public User getUser(){
        User user = new User();
        user.setAge(19);
        user.setName("shuang");
        System.out.println("Hello , " + user.getName());
        return user;
    }
}
