package com.coding.demo0517.controller;

import com.coding.demo0517.demo.User;
import com.coding.demo0517.mapper.Usermapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Slf4j
@RequestMapping("user2")
@RestController
public class User2Controller {
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
        User record = new User();
        record.setName(name);
        User user = userMapper.selectOne(record);

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
        User record = new User();
        record.setName(name);
        User user = userMapper.selectOne(record);
        if(user != null)
        {
            return "注册失败，用户已经存在";
        }
        user = new User();
        user.setName(name);
        user.setPassword(password);
        int resultCount = userMapper.insertSelective(user);
        if(resultCount  == 0)
        {
            return "注册失败";
        }


        return "注册成功";
    }
    @GetMapping("all")
    public List<User> all()
    {
        return userMapper.selectAll();
    }
    @GetMapping("allByName")
    public List<User> all(String name)
    {
        User record = new User();
        record.setName(name);
        return userMapper.select(record);
    }
}
