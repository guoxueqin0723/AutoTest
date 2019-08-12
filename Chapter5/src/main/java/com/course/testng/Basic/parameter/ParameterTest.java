package com.course.testng.Basic.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    //    参数化测试 XML文件参数化
    @Test
    @Parameters({"UserName","UserAge"})
    public void ParamTest1(String MyName,int MyAge){
        System.out.println("姓名："+MyName+",年龄："+MyAge+"岁");
    }

    /*public static void main(String[] arys){
        ParamterTest name=new ParamterTest();
        name.ParamTest1("张三",30);
    }*/
}
