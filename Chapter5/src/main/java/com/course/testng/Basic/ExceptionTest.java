package com.course.testng.Basic;

import org.testng.annotations.Test;

public class ExceptionTest {
    /**
     * 什么时候使用异常测试？
     * 在我们期望某个结果为异常的时候，
     * 例如：我们传入了某些不合法的参数，程序抛出了异常
     * 也就是说我的预期结果就是这个异常
     */
//    这是一个测试结果会失败的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试！");
    }
//    这是一个测试结果会成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSucessed(){
        System.out.println("这是一个成功的异常测试！");
        throw new RuntimeException();
    }
/*//    异常
    @Test
    public void runTimeExceptionFailed1(){
        System.out.println("没有属性的异常测试！");
        throw new RuntimeException();
    }*/
}
