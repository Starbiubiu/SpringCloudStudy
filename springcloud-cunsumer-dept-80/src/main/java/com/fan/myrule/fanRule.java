package com.fan.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class fanRule {

    @Bean
    public IRule myRule(){
//        return new RandomRule();
        return new FanRandomRule();//默认是轮询，现在定义为 FanRandomRule
    }


}
