package com.course.testng.Basic.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
//    BeforeGroups and AfterGroups  方法分组
    @Test(groups = "server")
    public void GroupsOnServer1() {
        System.out.println("这是服务端组1");
    }

    @Test(groups = "server")
    public void GroupsOnServer2() {
        System.out.println("这是服务端组2");
    }

    @Test(groups = "client")
    public void GroupsOnClient1() {
        System.out.println("这是客户端组1");
    }

    @Test(groups = "client")
    public void GroupsOnClient2() {
        System.out.println("这是客户端组2");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer() {
        System.out.println("server1----服务端之前的方法-----server1111");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer() {
        System.out.println("server2------服务端之后的方法-------server222");
    }
    @BeforeGroups("client")
    public void beforeGroupsOnClient() {
        System.out.println("client1------客户端之前的方法-------client1111");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient() {
        System.out.println("client2------客户端之后的方法----client222222！");
    }
}
