package com.yingxs.test;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.domain.Customer;
import com.yingxs.domain.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * ��ʾHibernate���������״̬
 * @author admin
 *
 */

public class Demo1 {


	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();	//��ʱ��c����û��OIDֵ��û�б�session������ʱc���������ʱ״̬�Ķ���
		c.setName("����");
		
		session.save(c);			//��ʱ��c������OID��ֵ����session���� �����ڳ־�̬����
		System.out.println(c.getId());
		
		tx.commit();
		session.close();
		
		System.out.println(c);			//��ʱ��c������OID��ֵ��û�б�session���� ����������̬����
		
	}
	
	
	
}
