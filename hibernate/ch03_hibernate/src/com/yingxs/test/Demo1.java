package com.yingxs.test;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * ��ʾ��������Ĳ�ѯ
 * @author admin
 *
 */

public class Demo1 {

	/*
	 * get()��������ѯһ������
	 */
	
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.get(Customer.class, 1);
		Set<Order> orders = cust.getOrders();
		System.out.println(cust.getName()+"�Ķ�����");
		for (Order order : orders) {
			System.out.println(order.getOrderno()+","+order.getProductName());
		}
		tx.commit();
		session.close();
		
	}
	
	
	
	
	
	/**
	 * load()��������ѯһ������
	 */
	
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.load(Customer.class, 1);
		Set<Order> orders = cust.getOrders();
		System.out.println(cust.getName()+"�Ķ�����");
		for (Order order : orders) {
			System.out.println(order.getOrderno()+","+order.getProductName());
		}
		tx.commit();
		session.close();
		
	}

}
