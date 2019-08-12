package com.course.testng.Basic.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age){
        System.out.println("姓名："+name+",年龄："+age);
    }
//    提供参数
    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] o=new Object[][]{{"张三",10}, {"李四",15}, {"王五",20}};
            return o;
    }
    ///////////////////////////////////////////////////////////////////////////////
    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1_name="+name+",test1_age="+age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2_name="+name+",test2_age="+age);
    }
    //    根据方法名，判断提供何种类型的参数
    @DataProvider(name = "methodData")
    public Object[][] methodDataTest2(Method method){
        Object[][] obj=null;
        if(method.getName().equals("test1")){
                obj=new Object[][]{{"林海芬",35},{"林森",38}};
        }
        else if(method.getName().equals("test2")){
            obj=new Object[][]{{"王华",40},{"沈迪",41}};
        }
        return obj;
    }
}
