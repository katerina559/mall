package com.s3.controller;

import com.s3.pojo.Admin;
import com.s3.service.impl.AdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    AdminServiceImpl adminService;

    @RequestMapping("/first")
    public String test(){
        return "page/admin/loginPage";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("pwd") String pwd,
                        HttpSession session){
        Admin admin = adminService.login(name, pwd);
        if(admin == null){
            return "404";
        }
        session.setAttribute("admin",admin);
        return "redirect:/product/show";
    }

}
