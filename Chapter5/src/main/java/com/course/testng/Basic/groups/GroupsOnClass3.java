package com.course.testng.Basic.groups;

import org.testng.annotations.Test;

@Test(groups = "tch")
public class GroupsOnClass3 {
    public void tch1(){
        System.out.println("GroupsOnClass3中的tch1");
    }
    public void tch2(){
        System.out.println("GroupsOnClass3中的tch2");
    }
}
