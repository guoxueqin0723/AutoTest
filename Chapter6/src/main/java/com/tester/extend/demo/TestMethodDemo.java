package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodDemo {
    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3(){
        Assert.assertEquals("hello","hello");
    }
    @Test
    public void MyLog(){
        Reporter.log("添加日志的输出-----这是我自己写的日志！");//添加日志的输出
        throw new RuntimeException("这是我自己运行时的异常！");
    }

}
