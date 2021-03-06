package com.boyang.landsense.avg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({"com.boyang.landsense"})
@EnableMongoRepositories("com.boyang.landsense.common.repo")
public class SenseAvgApplication {
    public static void main(String[] args) {
        SpringApplication.run(SenseAvgApplication.class, args);
    }
}

