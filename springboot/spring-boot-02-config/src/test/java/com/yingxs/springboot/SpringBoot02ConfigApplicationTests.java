package com.yingxs.springboot;

import com.yingxs.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springboot的单元测试
 * 可以在测试期间很方便的类似编码一样自动注入到容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {


	@Autowired
	Person person;

	@Test
	public void contextLoads() {
		System.out.println(person);
	}

}

