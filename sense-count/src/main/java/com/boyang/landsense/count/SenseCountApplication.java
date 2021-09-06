package com.boyang.landsense.count;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
@ComponentScan({"com.boyang.landsense"})
@EnableMongoRepositories("com.boyang.landsense.common.repo")
public class SenseCountApplication {
    public static void main(String[] args) {
        SpringApplication.run(SenseCountApplication.class, args);
    }
}
