package com.fan.springcloud;

import com.fan.myrule.fanRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

//Ribbon和Eureka整合以后，和护短可以直接调用，不用关心IP和端口号
@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就能去加载我们自定义的Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = fanRule.class)
public class DeptComsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptComsumer_80.class,args);
    }
}
