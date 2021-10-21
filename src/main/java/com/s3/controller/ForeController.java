package com.s3.controller;

import com.alibaba.fastjson.JSON;
import com.s3.pojo.Address;
import com.s3.pojo.User;
import com.s3.service.impl.AddressServiceImpl;
import com.s3.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fore")
public class ForeController {

    @Resource
    UserServiceImpl userService;
    @Resource
    AddressServiceImpl addressService;

    @RequestMapping("/toHome")
    public String first(){
        return "/page/fore/homePage";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/page/fore/loginPage";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public String login(@RequestParam(value = "username",required = false) String username,
                        @RequestParam(value = "password",required = false) String password,
                        HttpSession session){
        User user = userService.login(username, password);
        if(user != null){
            session.setAttribute("user",user);
            return "ok";
        }else{
            return "no";
        }
    }

    @RequestMapping("/toRegister")
    public String toRegister(Model model){
        // 获取省份
        model.addAttribute("addressList",addressService.getAddress());
        return "/page/fore/register";
    }

    @RequestMapping("/getCity")
    @ResponseBody
    public String getCity(@RequestParam("id") Integer id){
        List<Address> city = addressService.getCity(id);
        List<Address> childAddressList = addressService.getCity(Integer.parseInt(city.get(0).getAddressAreaId()));
        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put("addressList",city);
        map.put("childAddressList",childAddressList);
        String json = JSON.toJSONString(map);
        return json;
    }

    @RequestMapping("/getChild")
    @ResponseBody
    public String getChild(@RequestParam("id") Integer id){
        List<Address> addressList = addressService.getCity(id);
        Map<String,Object> map = new HashMap<>();
        map.put("addressList",addressList);
        map.put("success",true);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/doRegister")
    @ResponseBody
    public String doRegister(User user){
        int count = userService.register(user);
        Map<String,Object> map = new HashMap<>();
        if(count > 0){
            map.put("success",true);
        }else{
            map.put("success",false);
        }
        return JSON.toJSONString(map);
    }

}
