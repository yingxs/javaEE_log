package com.yingxs.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition  {

	/**
	 *  ConditionContext  判断条件使用的上下文对象(环境)
	 *  AnnotatedTypeMetadata 注释信息
	 */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 1.获取到ioc所使用的beanFactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		
		// 2.能获取到类加载器
		ClassLoader classLoader = context.getClassLoader();
		
		// 3.获取当前环境信息
		Environment environment = context.getEnvironment();
		// 4.获取bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		
		
		String property = environment.getProperty("os.name");
		// 判断容器中是否包含person，也可以给容器中注册bean
		boolean definiton = registry.containsBeanDefinition("person");
		
		if (property.contains("linux")) {
			return true;
		}
		return false;
	}

}
