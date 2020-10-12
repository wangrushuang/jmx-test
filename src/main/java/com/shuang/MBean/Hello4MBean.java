package com.shuang.MBean;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "com.shuang.MBean:name=Hello4")
public class Hello4MBean {
    private String name;

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
    public void printHello(String ame)
    {
        System.out.println("Hello , " + name);
    }
}
