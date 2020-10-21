package com.fan.springcloud.service;


import com.fan.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    boolean addDept(Dept dept);

    Dept quertById(Long id);

    List<Dept> queryAll();
}
