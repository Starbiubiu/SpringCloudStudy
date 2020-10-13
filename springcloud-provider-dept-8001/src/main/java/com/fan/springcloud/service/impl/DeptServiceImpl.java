package com.fan.springcloud.service.impl;

import com.fan.springcloud.dao.DeptDao;
import com.fan.springcloud.pojo.Dept;
import com.fan.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        boolean flag = deptDao.addDept(dept);
        return flag;
    }

    @Override
    public Dept quertById(Long id) {
        Dept dept = deptDao.quertById(id);
        return dept;
    }

    @Override
    public List<Dept> queryAll() {
        List<Dept> depts = deptDao.queryAll();
        return depts;
    }
}
