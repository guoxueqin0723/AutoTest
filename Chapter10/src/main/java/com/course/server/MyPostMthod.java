package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的post方法")
@RequestMapping("/v1")
public class MyPostMthod {
    //用户成功登录获取到cookies,然后再访问其他接口获取到列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功获取cookies信息",httpMethod = "POST")
    //response 用来将cookies信息放入响应结果中，其余两个传入的参数用来判断是否符合逻辑
    public String login(HttpServletResponse response,
                        @RequestParam(value = "UserName",required = true) String MyName,
                        @RequestParam(value = "UserPassword",required = true) String MyPassword){

        if(MyName.equals("zhangsan")&&MyPassword.equals("123456")){
           Cookie cookie=new Cookie("mylogin","OK");
            response.addCookie(cookie);
            return "用户登录成功！";
        }
        return "用户名或密码错误！";
    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，登录成功后获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u){
        //获取cookies
            Cookie[] cookies=request.getCookies();
        //验证获取的cookies信息的合法性
            if(Objects.isNull(cookies)){
                return "你必须携带cookies信息";
            }
            for(Cookie c:cookies){
                if(c.getName().equals("mylogin")
                        &&c.getValue().equals("OK")
                        &&u.getUserName().equals("zhangsan")
                        &&u.getPassword().equals("123456")){
                    User user =new User();
                    user.setName("lisi");
                    user.setAge(20);
                    user.setSex("male");
                    return user.toString();
                }
            }
            return "参数不合法！";
    }

}
