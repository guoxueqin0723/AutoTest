package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Api(value = "v1",description = "通过mybatis连接数据库")
@RequestMapping("v1")
public class Demo {
    //首先获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;

    //查询用户数
    @RequestMapping(value = "/getUserNum",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数",httpMethod = "GET")
    public int getUserNum(){
        return template.selectOne("getUserCount");
    }

    //插入用户
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int addUser(@RequestBody User MyUser){
        int result;
        result=template.insert("addMyUser", MyUser);
        return result;

    }

    //编辑用户
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int updateUser(@RequestBody User MyUser){
        return template.update("updateMyUser",MyUser);
    }
    //删除用户
    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public int deleteUser( int id){
        return template.delete("deleteMyUser",id);
    }
    }

