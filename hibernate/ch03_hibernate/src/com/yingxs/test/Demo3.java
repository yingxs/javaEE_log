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
 * ��ʾHQL�Ĳ�ѯ������ѯ��
 * 1.�����Ӳ�ѯ(inner join)
 * 2.�����Ӳ�ѯ(left join)
 * 3.�����Ӳ�ѯ(right join)
 *
 */

public class Demo3 {

	/**
	 * �����Ӳ�ѯ
	 * ֻ����ʾ���������ļ�¼
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//������ʾ�ͻ����ƺͶ�����Ʒ����
		Query query = session.createQuery("select c.name,o.productName from Customer c inner join c.orders o");
		List<Object[]> list = query.list();
	
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		tx.commit();
		session.close();
		
	}
	
	
	
	/**
	 * �����Ӳ�ѯ
	 * ��ߵı��ȫ����ʾ
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//������ʾ�ͻ����ƺͶ�����Ʒ����
		Query query = session.createQuery("select c.name,o.productName from Customer c left join c.orders o");
		List<Object[]> list = query.list();
		
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		tx.commit();
		session.close();
		
	}
	
	
	
	/**
	 * �����Ӳ�ѯ
	 * �ұߵı��ȫ����ʾ
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//������ʾ�ͻ����ƺͶ�����Ʒ����
		Query query = session.createQuery("select c.name,o.productName from Order o right join o.customer c");
		List<Object[]> list = query.list();
		
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		tx.commit();
		session.close();
		
	}
	
	
	
}
