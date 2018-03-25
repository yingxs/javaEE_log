package com.yingxs.test;


import org.hibernate.Session;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.utils.HibernateUtil;

/**
 * ��ʾ��������
 * @author admin
 *
 */

public class Demo7 {

	
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		//��1�β���
		Customer cust = session.get(Customer.class, 1);
		System.out.println(cust.getName());
		//�ر�session
		session.close();
		
		//��2�β���
		session = HibernateUtil.getSession();
		cust = session.get(Customer.class, 1);
		System.out.println(cust.getName());
		session.close();
	}
	
	
	
}
