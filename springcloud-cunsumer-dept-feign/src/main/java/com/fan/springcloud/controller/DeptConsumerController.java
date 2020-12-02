package com.fan.springcloud.controller;

import com.fan.springcloud.pojo.Dept;
import com.fan.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    //理解：  消费者  不应该有service层
    //RestTemplate ...供我们直接调用就可以  注册到Spring中
    //(url,实体: 一般用Map  class<T> responseType    )

    //提供多种便捷访问远程http服务的方法，简单的 restful 服务模板
    @Autowired
    private RestTemplate restTemplate;

//    //通过Ribbon实现的话   这里的地址,应该是一个变量，通过服务名来访问
////    private static final String REST_URL_PREFIX = "http://localhost:8001";
//    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";


    @Autowired
    private DeptClientService deptClientService;



    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return this.deptClientService.addDept(dept);
    }


    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.deptClientService.queryById(id);
    }


    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return this.deptClientService.queryAll();
    }
//
//    @GetMapping("/consumer/dept/discovery")
//    public Object dicovery(){
//        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
//    }

}
