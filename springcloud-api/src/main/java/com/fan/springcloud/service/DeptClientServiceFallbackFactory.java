package com.fan.springcloud.service;


import com.fan.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {


    @Override
    public DeptClientService create(Throwable throwable) {



        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id)
                        .setDname("id=>" + id + "没有对应的信息，客户端提供了降级的信息，此服务已关闭")
                        .setDb_source("没有数据");

            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
