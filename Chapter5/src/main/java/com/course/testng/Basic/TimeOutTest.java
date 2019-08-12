package com.course.testng.Basic;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000)//单位是毫秒，这里也就是3秒
    public void testSucessed() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("超时时间是3秒，等待了2秒，没有超时~");
    }
    @Test(timeOut = 3000)//超时了
    public void testFailed() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("超时时间是3秒，等待了4秒，超时啦！");
    }
}
