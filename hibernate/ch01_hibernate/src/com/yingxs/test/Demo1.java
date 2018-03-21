package com.yingxs.test;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yingxs.domain.Customer;

/**
 * hibernate��helloworld
 * @author admin
 *
 */
public class Demo1 {

	
	@Test
	public void test1(){
		Customer customer = new Customer();
		customer.setName("����22");
		customer.setAge(42);
		customer.setGender("��");
		customer.setLevel("VIP�ͻ�");
		
		
		
		//1.��ȡhibernate.cfg.xml�ļ�
		Configuration cfg = new Configuration();
		cfg.configure();
//		cfg.configure(new File("./src/hbm.cfg.xml"));
		
		
		//2.����SessionFactory����
		SessionFactory factory = cfg.buildSessionFactory();
		//3.����Session����
		Session session = factory.openSession();
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
