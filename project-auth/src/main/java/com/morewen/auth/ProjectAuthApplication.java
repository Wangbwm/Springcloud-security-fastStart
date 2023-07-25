package com.morewen.auth;

import com.morewen.common.security.annotation.EnableRyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * 认证授权中心
 * 
 * @author ruoyi
 */
@EnableRyFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = {"com.morewen", "com.morewen.api.system"})
public class ProjectAuthApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ProjectAuthApplication.class, args);
    }
}
