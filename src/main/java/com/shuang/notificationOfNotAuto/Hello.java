package com.shuang.notificationOfNotAuto;

import org.springframework.stereotype.Component;

/*
 * 该类名称必须与实现的接口的前缀保持一致（即MBean前面的名称
 */
@Component
public class Hello implements HelloMBean{
    private String name;

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void printHello()
    {
        System.out.println("Hello World, " + name);
    }

    @Override
    public void printHello(String whoName)
    {
        System.out.println("Hello , " + whoName);
    }
}
