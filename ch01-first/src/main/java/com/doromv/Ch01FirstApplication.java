package com.doromv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//排除Security的配置，让他不启用
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Ch01FirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch01FirstApplication.class, args);
    }

}
