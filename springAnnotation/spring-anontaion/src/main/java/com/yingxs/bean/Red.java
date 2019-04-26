package com.yingxs.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class Red  implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware {

	
	private ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("传入的IOC："+applicationContext);
		this.applicationContext  = applicationContext;
	}

	public void setBeanName(String name) {
		System.out.println("当前bean的名字："+name);
	}

	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		// TODO Auto-generated method stub
		String value = resolver.resolveStringValue("你好${os.name} ,  #{20*19}");
		System.out.println("解析的字符串"+value);
	}

}
