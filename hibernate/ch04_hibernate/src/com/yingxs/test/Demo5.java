package com.yingxs.test;


import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * ��ʾץȡ���ԵĹ���
 * @author admin
 *
 */

public class Demo5 {

	/***
	 * һ����<set/>
	 * fetch="select" ��Ĭ������£�ִ������SQL���
	 * fetch="join"	: ������SQL���ϲ����������Ӳ�ѯ(Ч�ʸ�һ�㣬�������������join�ӳټ���ʧЧ)
	 */

	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.get(Customer.class, 1);
		System.out.println(cust.getOrders());
		
		tx.commit();
		session.close();
	}
	
	
	/***
	 * һ����<set/>
	 * �����ڲ�ѯ���һ��(�ͻ�)�����ݣ�������ѯ�෽(����)�����ݣ����fetch��������select��ʱ��һ������n+1��sql���
	 * fetch="subselect"	: ʹ���Ӳ�ѯ���й�����ѯ
	 */
	
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer.getOrders().size());
		}
		
		tx.commit();
		session.close();
	}
	
	
	/***
	 * �෽��<many-to-one/>
	 * fetch="select" ��Ĭ������£�ִ������SQL��䣨֧����ʱ���أ�
	 * fetch="join"	: ������SQL���ϲ����������Ӳ�ѯ(Ч�ʸ�һ�㣬�������������join�ӳټ���ʧЧ)
	 * 
	 */

	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order order = session.get(Order.class, 1);
		System.out.println(order.getCustomer());
		
		tx.commit();
		session.close();
	}
	
}
