package com.coding.demo0517.controller;

import com.coding.demo0517.demo.User;
import com.coding.demo0517.mapper.Usermapper;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.acl.LastOwnerException;
import java.util.Objects;

@Slf4j
@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private Usermapper userMapper;


    @GetMapping("login")
    public String login(String name,String password){
        if(!StringUtils.hasLength(name))
        {
            return "用户名不允许为空";
        }
        if(!StringUtils.hasLength(password))
        {
            return "密码不允许为空";
        }
        User user = userMapper.selectUser(name);

        if(user == null)
        {
            return "登陆失败";
        }
        if(Objects.equals(password,user.getPassword()))
        {
            return "登录成功";
        }
        return "登陆失败密码错误";
    }
    @GetMapping("register")
    public  String register(String name,String password)
    {
        log.info("name:{}",name);
        log.info("password:{}",password);
        if(!StringUtils.hasLength(name))
        {
            return "用户名不允许为空";
        }
        if(!StringUtils.hasLength(password))
        {
            return "密码不允许为空";
        }
        User user = userMapper.selectUser(name);
        if(user != null)
        {
            return "注册失败，用户已经存在";
        }
        int resultCount = userMapper.saveUser(name,password);
        if(resultCount  == 0)
        {
            return "注册失败";
        }


        return "注册成功";
    }
}
