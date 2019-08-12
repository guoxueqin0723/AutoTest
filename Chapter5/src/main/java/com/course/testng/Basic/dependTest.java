package com.course.testng.Basic;

import org.testng.annotations.Test;

import javax.management.relation.RoleUnresolved;

public class dependTest {
    @Test(groups = "stu")
    public void stu1(){
        System.out.println("stu11111111运行");
    }
    @Test(groups = "stu",expectedExceptions = RuntimeException.class)
    public void stu2(){
        System.out.println("stu2222222运行");
    }
    @Test(dependsOnMethods = {"stu1"})
    public void stu3(){
        System.out.println("stu33333333运行");
    }
//    依赖于方法2，若是方法2运行失败，则方法4忽略不执行
    @Test(dependsOnMethods = {"stu2"})
    public void stu4(){
        System.out.println("stu4444444444");
    }
    @Test(groups = "tch")
    public void tch1(){
        System.out.println("tch11111111111");
    }
    @Test(groups = "tch")
    public void tch2(){
        System.out.println("tch2222222222");
    }
    @Test(dependsOnGroups = "tch")
    public void tch3(){
        System.out.println("tch333333333");
    }

}
