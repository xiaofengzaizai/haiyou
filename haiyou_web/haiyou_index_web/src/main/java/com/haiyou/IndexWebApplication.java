package com.haiyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @ Author     ：qjf
 * @ Date       ：Created in 10:40 2019/11/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.haiyou.db.feign")
public class IndexWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(IndexWebApplication.class,args);
    }
}
