package com.study.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.study.interceptor.LoggerInterceptor;

public class WebMvmConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
	       registry.addInterceptor(new LoggerInterceptor())
           .excludePathPatterns("/css/**", "/fonts/**", "/plugin/**", "/scripts/**");
	}

}
