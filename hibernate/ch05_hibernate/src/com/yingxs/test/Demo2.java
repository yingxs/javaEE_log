package com.yingxs.test;

import org.junit.Test;

import com.yingxs.Threadlocation.CustomerService;
import com.yingxs.domain.Customer;


/**
 * ��ʾThreadlocation
 * @author admin
 *
 */

public class Demo2 {

	

	/**
	 * û��Threadlocat
	 */
	@Test
	public void test1(){
		
		Customer c1 = new Customer();
		c1.setName("����");
		
		Customer c2 = new Customer();
		c2.setName("����");
		
		CustomerService service = new CustomerService();
		service.save(c1, c2);
	}
	
	
	
}
