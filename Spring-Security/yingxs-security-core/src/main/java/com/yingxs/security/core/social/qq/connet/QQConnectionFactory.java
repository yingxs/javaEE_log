package com.yingxs.security.core.social.qq.connet;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

import com.yingxs.security.core.social.qq.api.QQ;

public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

	public QQConnectionFactory(String providerId, String  appId, String  appSecret) {
		super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter() );
		// TODO Auto-generated constructor stub
	}
	

}
