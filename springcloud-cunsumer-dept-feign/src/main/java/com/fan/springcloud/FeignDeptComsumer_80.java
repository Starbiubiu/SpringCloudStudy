package com.fan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//Ribbon和Eureka整合以后，和护短可以直接调用，不用关心IP和端口号
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.fan.springcloud"})
@ComponentScan("com.fan")
public class FeignDeptComsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptComsumer_80.class,args);
    }
}
