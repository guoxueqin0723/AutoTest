package com.course.testng.Basic.paramter;

import org.testng.annotations.Test;

public class ParamterTest {
    @Test
    public void ParamTest1(String MyName,int MyAge){
        System.out.println("姓名："+MyName+",年龄："+MyAge+"岁");
    }

    /*public static void main(String[] arys){
        ParamterTest name=new ParamterTest();
        name.ParamTest1("张三",30);
    }*/
}
