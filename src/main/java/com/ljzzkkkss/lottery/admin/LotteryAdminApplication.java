package com.ljzzkkkss.lottery.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.ljzzkkkss.lottery.admin.mapper")
@EnableScheduling
@EnableCaching
@EnableTransactionManagement
public class LotteryAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotteryAdminApplication.class, args);
    }

}
