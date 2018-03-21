package com.yingxs.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.utils.HibernateUtil;
/**
 * ʹ��hibernateUtil������
 * @author admin
 *
 */
public class Demo2 {
	
	@Test
	public void test1(){
		Customer customer = new Customer();
		customer.setName("����22");
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
}
