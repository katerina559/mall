package com.s3.controller;

import com.alibaba.fastjson.JSON;
import com.s3.pojo.User;
import com.s3.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserServiceImpl userService;

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/fore/showHomePage";
    }

    @RequestMapping("/ajaxLogin")
    @ResponseBody
    public String doLogin(@RequestParam(value = "username",required = false) String username,
                          @RequestParam(value = "password",required = false) String password,
                          HttpSession session){
        User user = userService.login(username, password);
        Map<String,Object> map = new HashMap<>();
        if(user != null){
            map.put("success",true);
            session.setAttribute("user",user);
        }else{
            map.put("success",false);
        }
        return JSON.toJSONString(map);
    }

}
