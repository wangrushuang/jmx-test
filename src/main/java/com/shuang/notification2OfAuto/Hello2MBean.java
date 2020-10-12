package com.shuang.notification2OfAuto;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "com.shuang.notification2OfAuto:name=Hello2")
public class Hello2MBean {
    private String name;

    @ManagedAttribute
    public String getName() {
        return name;
    }

    @ManagedOperation
    @ManagedOperationParameter(name = "name", description = "set new name")
    public void setName(String name) {
        this.name = name;
    }

    @ManagedOperation
    public void printHello() {
        System.out.println("Hello World, " + name);
    }

    @ManagedOperation
    @ManagedOperationParameter(name = "name", description = "hello name")
    public void printHello(String name) {
        System.out.println("Hello , " + name);
    }
}
