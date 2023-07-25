package com.morewen.system;


import com.morewen.common.security.annotation.EnableCustomConfig;
import com.morewen.common.security.annotation.EnableRyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 系统模块
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableRyFeignClients
@SpringBootApplication
public class SystemApplication
{
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
