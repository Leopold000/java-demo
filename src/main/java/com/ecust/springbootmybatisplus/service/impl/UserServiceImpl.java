package com.ecust.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ecust.springbootmybatisplus.entity.User;
import com.ecust.springbootmybatisplus.mapper.UserMapper;
import com.ecust.springbootmybatisplus.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public Page<User> page(Integer current, Integer size, String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //推荐写法
        if (!"".equals(username)) {
            //模糊查询
            wrapper.like(User::getUsername, username);
        }
        Page<User> page = page(new Page<>(
                        current,
                        size
                ),
                wrapper
        );
        return page;
    }

    @Override
    public boolean saveOrUpdateById(User user) {
        if (user.getId() != null) {
            return updateById(user);
        } else {
            return save(user);
        }
    }

    @Override
    public boolean deleteBachIds(List<Integer> ids) {
        return removeBatchByIds(ids);
    }

    @Override
    public boolean findByUsername(String username, String password) {
        User user = getOne(new LambdaQueryWrapper<User>()
               .eq(User::getUsername, username)
               .eq(User::getPassword, password)
        );
        return user != null;
    }


}
