package com.course.testng.Basic.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {
    @Test
    public void test1(){
//        打印线程id
        System.out.printf("Thread id: %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test2(){
//        打印线程id
        System.out.printf("Thread id: %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test3(){
//        打印线程id
        System.out.printf("Thread id: %s%n",Thread.currentThread().getId());
    }

}
