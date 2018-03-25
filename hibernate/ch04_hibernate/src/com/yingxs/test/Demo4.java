package com.yingxs.test;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * ��ʾ�ӳټ���
 * @author admin
 *
 */

public class Demo4 {

	/***
	 * �༶����ӳټ���
	 */

	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		/*
		//get():get������֧���༶����ӳټ���
		Customer cust = session.get(Customer.class, 1);
		System.out.println(cust.getName());
		*/
		
		
		
		//load():load():ֻ��load������֧���༶����ӳټ���
		Customer cust = session.load(Customer.class, 1);
		System.out.println(cust.getName());
		
		
		tx.commit();
		session.close();
	}
	
	/**
	 * ����������ӳټ���( һ�Զ�: <set/> )
	 * �޸�һ�Զ���ӳټ������ã�
	 * 		<set name="orders"  inverse="true" lazy="false">
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.get(Customer.class, 1);
		//��������
		System.out.println(cust.getOrders().size());	//�ӳټ��ص�
		
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 
	 * ����������ӳټ���( ���һ: <many-to-one/> )
	 * �޸Ķ��һ���ӳټ������ã�
	 * 		<many-to-one name="customer" class="Customer" column="cust_id" lazy="false" ></many-to-one>
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order order = session.get(Order.class, 1);
		System.out.println(order.getCustomer().getName());		//���ӳټ���
		
		tx.commit();
		session.close();
	}
	
}
