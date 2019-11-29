package com.haiyou.db;

import com.haiyou.entity.IdWorker;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ Author     ：qjf
 * @ Date       ：Created in 13:43 2019/11/27
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
@MapperScan(basePackages = {"com.haiyou.db.dao"})
public class DbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(0, 0);
    }
}

