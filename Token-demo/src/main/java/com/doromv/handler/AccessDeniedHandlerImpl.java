package com.doromv.handler;

import com.alibaba.fastjson.JSON;
import com.doromv.utils.ResponseResult;
import com.doromv.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Doromv
 * @create 2022-04-25-8:56
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        ResponseResult result=new ResponseResult(HttpStatus.FORBIDDEN.value(),"您的权限不足");
        String s = JSON.toJSONString(result);
        //处理异常
        WebUtils.renderString(response,s);
    }
}
