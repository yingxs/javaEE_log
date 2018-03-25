package com.yingxs.test;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * ��ʾһ������Ϳ��ջ���
 * @author admin
 *
 */

public class Demo2 {


	/**
	 * ˵���־�̬����ȷʵ���Ը������ݿ������
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//��ȡ��һ���־�̬����
		Customer cust = session.get(Customer.class, 1);
		cust.setName("����");
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * ʹ�ô�����֤��hibernateһ������Ĵ���
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//��һ�β�ѯ
		Customer c1 = session.get(Customer.class, 1);
		System.out.println(c1);
		//�ڶ��β�ѯ
		Customer c2 = session.get(Customer.class, 1);
		System.out.println(c2);
		
		
		tx.commit();
		session.close();
	}
	
	
	
}
