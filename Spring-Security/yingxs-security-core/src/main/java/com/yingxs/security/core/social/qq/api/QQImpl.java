package com.yingxs.security.core.social.qq.api;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author admin
 *
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

	private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
	private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
	
	private String appId;
	private String openId;
	
	private ObjectMapper objectMapper= new ObjectMapper();
	
	
	public QQImpl(String accessToken,String appId) {
		// TokenStrategy.ACCESS_TOKEN_PARAMETER token策略 将token作为参数传递
		super(accessToken,TokenStrategy.ACCESS_TOKEN_PARAMETER);
		this.appId = appId;
		
		// 获取openId
		String url = String.format(URL_GET_OPENID, accessToken);
		String result = getRestTemplate().getForObject(url, String.class);
		
		System.out.println(result);
		this.openId = StringUtils.substringBetween(result, "\"openid\":", "}");
	}
	
	
	
	
	@Override
	public QQUserInfo getUserInfo() throws Exception {
		String url = String.format(URL_GET_USERINFO, appId,openId);
		String result = getRestTemplate().getForObject(url, String.class);
		System.out.println(result);
		return objectMapper.readValue(result, QQUserInfo.class);
	}

}
