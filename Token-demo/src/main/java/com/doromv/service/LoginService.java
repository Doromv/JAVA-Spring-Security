package com.doromv.service;

import com.doromv.pojo.User;
import com.doromv.utils.ResponseResult;

/**
 * @author Doromv
 * @create 2022-04-23-11:15
 */
public interface LoginService {
    ResponseResult login(User user);
}
