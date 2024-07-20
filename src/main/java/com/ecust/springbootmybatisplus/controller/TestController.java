package com.ecust.springbootmybatisplus.controller;

import com.ecust.springbootmybatisplus.entity.User;
import com.ecust.springbootmybatisplus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/test")
    public List<User> list(){
        return userMapper.selectList(null);
    }
}
