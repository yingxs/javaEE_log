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
 * ��ʾHQL�Ĳ�ѯ�������ѯ��
 * 1.ȫ���ѯ
 * 2.������ѯ
 * 3.������ѯ
 * 4.������ѯ
 * 5.��ҳ��ѯ
 * 6.��ѯ����
 * 7.�ۺϲ�ѯ
 * 8.ͶӰ��ѯ
 * @author admin
 *
 */

public class Demo4 {

	/**
	 * ȫ���ѯ
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * ������ѯ
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("select o from Order o");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * ������ѯ
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order where orderno = '201709070001'");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * ������ѯ2
	 */
	@Test
	public void test4(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order where orderno = ?");
		query.setParameter(0, "201709070001");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	/**
	 * ������ѯ
	 */
	@Test
	public void test5(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order where orderno = :orderno");
		query.setParameter("orderno", "201709070001");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * ��ҳ��ѯ
	 */
	@Test
	public void test6(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order");
		//������ʼ�У���0��ʼ
		query.setFirstResult(0);
		//���ò�ѯ������
		query.setMaxResults(2);
		
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	/**
	 * ��ѯ����
	 */
	@Test
	public void test7(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order order by id desc");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * �ۺϲ�ѯ
	 */
	@Test
	public void test8(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("select count(*) from Order");
		/**
		//�﷨һ:
		List<Long> list = query.list();
		Long count = list.get(0);
		System.out.println(count);
		*/
		
		Long count = (Long)query.uniqueResult();
		System.out.println(count);
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * ͶӰ��ѯ ��ѯ�ֲ��ֶ�
	 */
	@Test
	public void test9(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("select orderno,productName from Order");
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
	 * ͶӰ��ѯ2
	 */
	@Test
	public void test10(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("select new com.yingxs.domain.Order(orderno,productName) from Order");
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order.getOrderno()+"\t"+order.getProductName());
		}
		tx.commit();
		session.close();
		
	}
	
}
