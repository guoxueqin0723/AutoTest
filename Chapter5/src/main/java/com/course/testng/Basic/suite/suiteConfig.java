package com.course.testng.Basic.suite;

import org.testng.annotations.*;

public class suiteConfig {
    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("BeforeSuite测试");
    }

    @AfterSuite
    public void AfterSuite() {
        System.out.println("AfterSuite测试");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest 测试");
    }

    @AfterTest
    public void AfterTest() {
        System.out.println("AfterTest 测试");
    }
 /*   @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BeforeMethod 测试");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod 测试");
    }*/
}
