package com.fan.springcloud.dao;

import com.fan.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept quertById(Long id);

    List<Dept> queryAll();

}
