package com.scene.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 配置允许跨域的路径
                .allowedOrigins("*")  // 允许所有来源
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 配置允许的请求方法
                .allowedHeaders("*")  // 配置允许的请求头
                .allowCredentials(true);  // 是否允许发送 cookies
    }
}

