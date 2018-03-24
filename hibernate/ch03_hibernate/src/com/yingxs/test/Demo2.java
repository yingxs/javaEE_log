package com.yingxs.test;


import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * ��ʾCriteria�Ĳ�ѯ�������ѯ��
 * 1.ȫ���ѯ
 * 2.������ѯ
 * 3.��ҳ��ѯ
 * 4.��ѯ����
 * 5.�ۺϲ�ѯ
 * 6.ͶӰ��ѯ
 * @author admin
 *
 */

public class Demo2 {

	/**
	 * ȫ���ѯ
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Customer.class);
		List<Customer> list = ce.list();
		for (Customer customer : list) {
			System.out.println(customer.getName());
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
		
		Criteria ce = session.createCriteria(Order.class);
		//��Ӳ�ѯ���� orderno = '20170907003'
		ce.add( Restrictions.eq("orderno", "201709070003") );
		List<Order> list = ce.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * ������ѯ2(������)
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		
		//��Ӳ�ѯ���� orderno like '%2017%' and productName like '%JavaWeb%'
		ce.add( Restrictions.and(Restrictions.like("orderno", "%2017%"), Restrictions.like("productName", "%JavaWeb%")));
		List<Order> list = ce.list();
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
	public void test4(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		//��ҳ��ѯ
		ce.setFirstResult(0);	//��ʼ��
		ce.setMaxResults(2);	//��ѯ����
		
		
		List<Order> list = ce.list();
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
	public void test5(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		
		//���� order by id desc
		ce.addOrder( org.hibernate.criterion.Order.desc("id"));
		
		List<Order> list = ce.list();
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
	public void test6(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		
		//��ѯ�ܼ�¼�� select count (id)
		//ce.setProjection(Projections.count("id"));
		
		//��ѯid�е����ֵ
		ce.setProjection(Projections.max("id"));
		
		Integer count = (Integer)ce.uniqueResult();
		System.out.println(count);
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * ͶӰ��ѯ
	 */
	@Test
	public void test7(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria ce = session.createCriteria(Order.class);
		
		//ͶӰ����
		ProjectionList pList = Projections.projectionList();
		pList.add(Property.forName("orderno"));
		pList.add(Property.forName("productName"));
		
		ce.setProjection(pList);
		
		List<Object[]> list = ce.list();
		System.out.println(list);
		
		/*for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}*/
		
		tx.commit();
		session.close();
		
	}
	
}
