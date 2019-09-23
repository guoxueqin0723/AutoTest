package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private String TestUrl;
    private String TestUri;
    private String MyUrl;
    private String MyUri;
    private ResourceBundle bundle;
    CookieStore store;

    @BeforeTest
    public void beforeTest() {
//        获取配置文件的内容
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
        TestUri = bundle.getString("getCookiesUri");
//        从配置文件中拼接测试url
       TestUrl = this.url + this.TestUri;
    }

    @Test
    public void getCookies() throws IOException {
        HttpGet get = new HttpGet(TestUrl);
//        这个是用来执行get方法
        HttpClient client = new DefaultHttpClient();
        HttpResponse execute = client.execute(get);
        String result = EntityUtils.toString(execute.getEntity(), "UTF-8");
        System.out.println(result);
//          获取cookies信息
        store=((DefaultHttpClient) client).getCookieStore();
        List<Cookie> cookieList =store.getCookies();
//        打印输出cookie信息
        for(Cookie cookie:cookieList){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookie name="+name+",cookie value="+value);
        }

    }

    @Test(dependsOnMethods = {"getCookies"})
    public void testWithCookie() throws IOException {
        //    拼接需要携带cookies才能访问的URL
        MyUri=bundle.getString("test.get.with.cookies");
        MyUrl = this.url + this.MyUri;
        HttpGet get =new HttpGet(this.MyUrl);
        HttpClient client=new DefaultHttpClient();

//        设置cookies信息
        ((DefaultHttpClient) client).setCookieStore(this.store);
       HttpResponse response= client.execute(get);

//      获取响应的状态码
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println("statusCode="+statusCode);
        if(statusCode==200){
           String result=EntityUtils.toString(response.getEntity(),"UTF-8");
//            String result=response.getEntity().toString();//该语句解决不了乱码问题
            System.out.println(result);
        }
        else {
            System.out.println("执行错误！");
        }
    }
}

