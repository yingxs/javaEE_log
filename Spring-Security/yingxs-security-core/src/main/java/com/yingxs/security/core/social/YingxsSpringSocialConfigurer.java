package com.yingxs.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

public class YingxsSpringSocialConfigurer extends SpringSocialConfigurer {

	private String filterProcessesUrl ;
	
	private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;
	
	
	public YingxsSpringSocialConfigurer(String filterProcessesUrl) {
		this.filterProcessesUrl = filterProcessesUrl;
	}



	@SuppressWarnings("unchecked")
	@Override
	protected <T> T postProcess(T object) {
		
		// 获取父类的处理结果
		SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
		
		// 设置过滤器处理的路径
		filter.setFilterProcessesUrl(filterProcessesUrl);
		
		if (socialAuthenticationFilterPostProcessor != null) {
			socialAuthenticationFilterPostProcessor.process(filter);
		}
		return (T) filter;
	}



	public SocialAuthenticationFilterPostProcessor getSocialAuthenticationFilterPostProcessor() {
		return socialAuthenticationFilterPostProcessor;
	}



	public void setSocialAuthenticationFilterPostProcessor(
			SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor) {
		this.socialAuthenticationFilterPostProcessor = socialAuthenticationFilterPostProcessor;
	}
	
	
	

}
