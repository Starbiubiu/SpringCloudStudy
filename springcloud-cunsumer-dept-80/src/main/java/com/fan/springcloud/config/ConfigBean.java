package com.fan.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {  //@Configuration  相当于Spring  applicationContext.xml

    //配置负载均衡实现RestTemplate
    //IRule
    //RoundRobinRule ： 轮询
    //RandomRule ： 随机
    //RetryRule ：会先按照轮询获取服务，如果服务获取失败，则会在指定的时间内重试
    //AvailabilityFilteringRule: 会先过滤掉  跳闸（崩溃）/访问故障的服务，对剩下的进行轮询
    @Bean
    @LoadBalanced   //Ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


//    @Bean
//    public IRule myRule(){
//        return new RandomRule();
//    }

}
