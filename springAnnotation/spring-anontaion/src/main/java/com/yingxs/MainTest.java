package com.yingxs;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.yingxs.bean.Person;
import com.yingxs.config.MainConfig;
import com.yingxs.config.MainConfig2;

public class MainTest {

	/**
	 * xml 方式获取bean
	 */
	@Test
	public void test1() {
		// 根据配置文件创建容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Person bean = (Person)applicationContext.getBean("person");
		System.out.println(bean);
	}
	
	
	
	/**
	 * 注解驱动获取bean
	 */
	@Test
	public void test2() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);
		
		// 容器中该类型的所有组件id 也就是配置类中 返回该bean的方法名
		//但如果@bean中定义了该bean的name那就后者优先
		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String string : namesForType) {
			System.out.println(string);
		}
	}
	
	@Test
	public void test3() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		// 获取容器中所有bena的name
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : definitionNames) {
			System.out.println(string);
		}
	}
	
	@Test
	public void test4() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//		// 获取容器中所有bena的name
		System.out.println("容器创建完成");
//		String[] definitionNames = applicationContext.getBeanDefinitionNames();
//		for (String string : definitionNames) {
//			System.out.println(string);
//		}
//		
		Object bean = applicationContext.getBean("person");
//		Object bean2 = applicationContext.getBean("person");
//		System.out.println(bean == bean2);
		
	}
	@Test
	public void test5() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		String[] nameForType = applicationContext.getBeanNamesForType(Person.class);
	
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println(property);
		for (String name : nameForType) {
			System.out.println(name);
		}
		
		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		for (String key : persons.keySet()) {
			System.out.println(key+"===>"+persons.get(key));
		}
	}
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
	
	@Test
	public void testImport() {
		printBeans(applicationContext);
		
		// 工厂bean获取的是调用getObject创建的对象
		Object bean = applicationContext.getBean("colorFactoryBean");
		Object bean2 = applicationContext.getBean("colorFactoryBean");
		//获取colorFactoryBean本身
		Object bean3 = applicationContext.getBean("&colorFactoryBean");
		System.out.println(bean==bean2);
		System.out.println(bean3);
	}
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext ) {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
		
		
	}
	
	
	
	
	
	
	
}
