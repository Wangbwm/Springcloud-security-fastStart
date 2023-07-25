package com.morewen.projectapitest;

import com.morewen.projectfeign.client.TestClient;
import com.morewen.projectfeign.config.DefaultFeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Wangbw
 */ // 关闭数据库自动配置
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.morewen"})
@EnableFeignClients(clients = TestClient.class, defaultConfiguration = DefaultFeignConfiguration.class)
public class ProjectApiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApiTestApplication.class, args);
    }

}
