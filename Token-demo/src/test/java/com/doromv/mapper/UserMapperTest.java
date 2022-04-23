package com.doromv.mapper;

import com.doromv.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author Doromv
 * @create 2022-04-23-9:10
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void findAllUser(){
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void TestPasswordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //$2a$10$3SnPojcGQc3dkdhfJCwaS.xbZ6vPOHJlCnr.RfX55PooMaI6PvVEa
        //$2a$10$WKez1YY6koNH7AqnuIq/m.uCJPuI6NzoZhWgfony7AnthtjLxB3Qq
        System.out.println(bCryptPasswordEncoder.matches("123456", "$2a$10$3SnPojcGQc3dkdhfJCwaS.xbZ6vPOHJlCnr.RfX55PooMaI6PvVEa"));
//        String str1 = bCryptPasswordEncoder.encode("123456");
//        String str2 = bCryptPasswordEncoder.encode("123456");
//        System.out.println(str1);
//        System.out.println(str2);
    }
}
