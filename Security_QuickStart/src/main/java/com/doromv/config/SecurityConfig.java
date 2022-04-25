package com.doromv.config;

import com.doromv.handler.FailureHandler;
import com.doromv.handler.LogoutSuccessHandler;
import com.doromv.handler.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author Doromv
 * @create 2022-04-25-20:25
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;
    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                //配置认证成功处理器
                .successHandler(successHandler)
                //配置认证失败处理器
                .failureHandler(failureHandler)
                .and()
                //配置登出成功处理器
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
