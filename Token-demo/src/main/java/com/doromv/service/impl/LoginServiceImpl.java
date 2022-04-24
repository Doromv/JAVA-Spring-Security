package com.doromv.service.impl;

import com.doromv.pojo.LoginUser;
import com.doromv.pojo.User;
import com.doromv.service.LoginService;
import com.doromv.utils.JwtUtil;
import com.doromv.utils.RedisCache;
import com.doromv.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Doromv
 * @create 2022-04-23-11:16
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    RedisCache redisCache;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public ResponseResult login(User user) {
        //通过AuthenticationManager的authenticate方法来进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //如果认证没通过，给出对应的提示
        if(authenticate==null){
            throw new RuntimeException("登入失败");
        }
        //如果认证通过则使用userid生成一个jwt
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        Map<String,String> map=new HashMap<>();
        map.put("token",jwt);
        //把完整的用户信息存入redis，userid作为key
        redisCache.setCacheObject("login:"+userId, loginUser);
        return new ResponseResult(200,"登入成功",map);
    }

    @Override
    public ResponseResult logout() {
        //获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken)
                        SecurityContextHolder.getContext().getAuthentication();
         LoginUser loginUser = (LoginUser) authentication.getPrincipal();
         Long id = loginUser.getUser().getId();
        //删除redis中的值
        redisCache.deleteObject("login:"+id);
        return new ResponseResult(200,"注销成功");
    }
}
