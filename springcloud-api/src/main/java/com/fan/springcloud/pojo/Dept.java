package com.fan.springcloud.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//Dept 实体类   orm  类表关系映射
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptno;
    private String dname;
    //这个字段是表示存在哪个数据库的字段   微服务  一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }


    /*
        链式写法
        Dept dept = new Dept();

        dept.setDeptNo(11).setDname('ss').setDb_source('001');



     */
}
