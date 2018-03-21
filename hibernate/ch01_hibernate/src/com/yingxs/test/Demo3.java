package com.yingxs.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.utils.HibernateUtil;
/**
 * ��ʾSession�ӿڽ�����ɾ�Ĳ�
 * @author admin
 *
 */
public class Demo3 {
	/**
	 * save();
	 */
	@Test
	public void test1(){
		Customer customer = new Customer();
		customer.setName("����333");
		customer.setAge(42);
		customer.setGender("��");
		customer.setLevel("VIP�ͻ�");
		
		
		Session session = HibernateUtil.getSession();

		//4.��������,�����񲢷����������
		Transaction tx = session.beginTransaction();
		//5.ִ����Ӳ���
		session.save(customer);
		//6.�ύ����
		tx.commit();
		//7.�ر���Դ
		session.close();
		
	}
	
	/**
	 * update();
	 */
	@Test
	public void test2(){
		Customer customer = new Customer();
		//��Customer��id��ֵ���ſ��Ը���
		customer.setId(1);
		customer.setName("����333");
		customer.setAge(45);
		customer.setGender("��");
		customer.setLevel("VIP�ͻ�");
		
		
		Session session = HibernateUtil.getSession();

		//4.��������,�����񲢷����������
		Transaction tx = session.beginTransaction();
		//5.ִ����Ӳ���
		session.update(customer);
		//6.�ύ����
		tx.commit();
		//7.�ر���Դ
		session.close();
		
	}
	
	
	
	/**
	 * saveOrUpdate(Object obj);��ӻ��޸Ķ���
	 * ��idΪupdate����idΪsave
	 */
	@Test
	public void test3(){
		Customer customer = new Customer();
		//��Customer��id��ֵ���ſ��Ը���
		customer.setId(6);
		customer.setName("����666");
		customer.setAge(50);
		customer.setGender("��");
		customer.setLevel("VIP�ͻ�");
		
		
		Session session = HibernateUtil.getSession();

		//4.��������,�����񲢷����������
		Transaction tx = session.beginTransaction();
		//5.ִ����Ӳ���
		session.saveOrUpdate(customer);
		//6.�ύ����
		tx.commit();
		//7.�ر���Դ
		session.close();
		
	}
	

	/**
	 * delete(Object obj);ɾ������
	 * ��idΪupdate����idΪsave
	 */
	@Test
	public void test4(){
		Customer customer = new Customer();
		//��Customer��id��ֵ���ſ��Ը���
		customer.setId(2);
		Session session = HibernateUtil.getSession();
		//4.��������,�����񲢷����������
		Transaction tx = session.beginTransaction();
		//5.ִ����Ӳ���
		session.delete(customer);
		//6.�ύ����
		tx.commit();
		//7.�ر���Դ
		session.close();
		
	}
	

	/**
	 * get(Class clz,Serialize id): ��ȡ����
	 * load(Class clz,Serialize id): ��ȡ����
	 */
	@Test
	public void test5(){
		Session session = HibernateUtil.getSession();
		//4.��������,�����񲢷����������
		Transaction tx = session.beginTransaction();
		//5.ִ����Ӳ���
//		Customer cust = session.get(Customer.class,6);
		Customer cust = session.load(Customer.class,6);
		System.out.println(cust);
		//6.�ύ����
		tx.commit();
		//7.�ر���Դ
		session.close();
		
	}
}
