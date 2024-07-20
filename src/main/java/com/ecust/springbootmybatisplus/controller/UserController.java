package com.ecust.springbootmybatisplus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ecust.springbootmybatisplus.entity.User;
import com.ecust.springbootmybatisplus.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//第一种跨域请求解决方式
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 分页列表 模糊查询
     * @param username 用户名
     * @param current 当前页
     * @paramsize 每页大小
     * return Page<User>
     */
    @GetMapping("/page")
    public Page<User> page(
//            @RequestParam("username") String username,
            @RequestParam(defaultValue = "") String username,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size
    ){
        return userService.page(current, size, username);
    }

    /**
     * 数据保存与新增
     * @param user
     * @return
     */
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.saveOrUpdateById(user);
    }

    /**
     * 单选删除或批量删除
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    public boolean deleteBatchIds(@RequestBody List<Integer> ids){
        return userService.deleteBachIds(ids);
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @PostMapping("/register")
    public boolean register(@RequestBody User user) {
        return userService.saveOrUpdateById(user);
    }
    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("/login")
    public boolean login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.findByUsername(username, password);
    }

}
