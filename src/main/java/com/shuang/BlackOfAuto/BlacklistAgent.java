package com.shuang.BlackOfAuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class BlacklistAgent {

    @Autowired
    BlacklistMBean blacklistMBean;

    @GetMapping("/blacklist")
    public String[] test1(){
        String[] ips=blacklistMBean.getBlacklist();
        System.out.println(Arrays.toString(ips));
        System.out.println("成功调用黑名单");
        return ips;
    }
}
