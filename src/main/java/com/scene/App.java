package com.scene;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.scene.mapper")
@EnableAsync
@EnableScheduling

public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}