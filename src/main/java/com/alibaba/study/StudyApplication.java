package com.alibaba.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootConfiguration
@PropertySource(value = "classpath:config/application.properties")
@ComponentScan({"com.slyak","com.alibaba.study"})
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableJpaAuditing
@EnableTransactionManagement
@MapperScan(basePackages = {"com.alibaba.study.mapper"})
public class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

}
