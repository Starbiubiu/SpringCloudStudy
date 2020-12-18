package com.fan.springcloud.controller;

import com.fan.springcloud.pojo.Dept;
import com.fan.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {


    @Autowired
    private DeptService deptService;

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.quertById(id);

        if(dept == null){
            throw new RuntimeException("id=》" + id + "不存在该用户");
        }
        return dept;
    }



    //备选方法
    public Dept hystrixGet(@PathVariable("id") Long id){

        return new Dept()
                .setDeptno(id)
                .setDname("id=》" + id + "不存在该用户")
                .setDb_source("no this database");
    }

}
