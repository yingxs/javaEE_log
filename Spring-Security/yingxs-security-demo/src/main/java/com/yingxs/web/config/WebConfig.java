package com.yingxs.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yingxs.web.filter.TimeFilter;
import com.yingxs.web.interceptor.TimeInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private TimeInterceptor timeInterceptor;

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
	}
	
	
	
	
//	@Bean
//	public FilterRegistrationBean timeFilter() {
//		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//		TimeFilter timeFilter = new TimeFilter();
//		registrationBean.setFilter(timeFilter);
//		List<String> urls = new ArrayList<>();
//		urls.add("/*");
//		registrationBean.setUrlPatterns(urls);
//		
//		
//		return registrationBean;
//		
//		
//	}
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(timeInterceptor);
//	}
	
	
	
	
	
	

}
