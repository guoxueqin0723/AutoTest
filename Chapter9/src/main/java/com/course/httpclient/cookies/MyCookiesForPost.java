package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
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
    public void testPostMethod() throws IOException {
        String uri=bundle.getString("test.post.with.cookies");
        //拼接最终的测试地址
        String testUrl=this.url+uri;

        //声明client对象，用来进行方法的执行
        HttpClient client=new DefaultHttpClient();

        //声明一个方法，这个方法就是post方法
        HttpPost  post=new HttpPost();

        // 添加参数
         JSONObject param= new JSONObject();
         param.put("name","guoxueqin");
         param.put("level","CET-6");

        //设置请求信息，这是header
        post.setHeader("Content-Type","application/json");

        //将参数信息添加到方法中
        StringEntity entity=new StringEntity(param.toString(),"UTF-8");
        post.setEntity(entity);

        //声明一个对象，用来进行相应结果的存储
        String result;

        //设置cookies信息
        ((DefaultHttpClient) client).setCookieStore(store);

        //执行post方法
        HttpResponse response=client.execute(post);

        //获取响应结果
        result=EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(result);

        //处理结果，就是判断返回结果是否符合预期
        //将返回的响应结果字符串转换成json对象
        JSONObject resultjson=new JSONObject(result);


        //获取到结果值
        String success=(String) resultjson.get("guoxueqin");
        String status=(String)resultjson.get("status");

        //具体的判断返回结果值
        Assert.assertEquals("okkk",success);
        Assert.assertEquals("1",status);

    }
}
