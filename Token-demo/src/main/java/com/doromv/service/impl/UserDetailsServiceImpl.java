package com.doromv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.doromv.mapper.MenuMapper;
import com.doromv.mapper.UserMapper;
import com.doromv.pojo.LoginUser;
import com.doromv.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Doromv
 * @create 2022-04-23-9:25
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User result = userMapper.selectOne(queryWrapper);
        if(result==null){
            throw new RuntimeException("用户名或者密码错误");
        }
        //查询对应的权限信息
        List<String> list = menuMapper.selectPermsByUserId(result.getId());
        //把数据封装成UserDetails返回
        return new LoginUser(result,list);
    }
}
