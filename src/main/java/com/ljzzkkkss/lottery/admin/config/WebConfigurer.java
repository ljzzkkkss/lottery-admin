package com.ljzzkkkss.lottery.admin.config;

import com.ljzzkkkss.lottery.admin.config.interceptors.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login","/templates/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态资源处理
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }
}
