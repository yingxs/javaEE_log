package com.yingxs.test;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * ��ʾһ������Ĺ���
 * @author admin
 *
 */

public class Demo3 {


	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.get(Customer.class, 1);		//cust�ǳ־�̬������һ��������
		cust.setName("����");
		
		//��cust�����Ƴ�һ������
//		session.evict(cust);
		
		
		//��� һ������
		session.clear();
		
		tx.commit();
		session.close();
	}
	
}
