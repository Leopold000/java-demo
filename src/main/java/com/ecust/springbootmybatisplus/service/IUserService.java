package com.ecust.springbootmybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ecust.springbootmybatisplus.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {
    Page<User> page(Integer current, Integer size, String username);

    boolean saveOrUpdateById(User user);

    boolean deleteBachIds(List<Integer> ids);

    boolean findByUsername(String username, String password);

}
