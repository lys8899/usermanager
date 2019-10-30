package com.lys.usermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @description: 启动类
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 14:47
 **/
@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
public class UsermanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermanagerApplication.class, args);
    }
}
