package com.yingxs.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.one2many.Customer;
import com.yingxs.one2many.Order;
import com.yingxs.utils.HibernateUtil;

/**
 * ��ʾһ�Զ�Ĳ���
 */
public class Demo2 {

	/**
	 * �������
	 */
	@Test
	public void test1(){
		
		//׼������
		//����һ���ͻ����Ŷ���
		Customer cust = new Customer();
		cust.setName("С��");
		cust.setGender("Ů");
		
		
		Order o1 = new Order();
		o1.setOrderno("201709070001");
		o1.setProductName("JavaWeb�������");
		
		Order o2 = new Order();
		o2.setOrderno("201709070002");
		o2.setProductName("Spring�������");
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//����һ�Զ�˫�������ϵ
		cust.getOrders().add(o1);
		cust.getOrders().add(o2);
		o1.setCustomer(cust);
		o2.setCustomer(cust);
		
		
		session.save(cust);
		session.save(o1);
		session.save(o2);
		
		tx.commit();
		session.close();
		
	}
	
	
	/**
	 * ��ѯ����
	 */
	@Test
	public void test2(){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//��ѯһ���ͻ���������ѯ����
		Customer cust = session.get(Customer.class, 1);
		System.out.println(cust.getName()+"�Ķ�����");
		Set<Order> orders = cust.getOrders();
		for (Order order : orders) {
			System.out.println(order.getOrderno()+" , "+order.getProductName());
		}
		tx.commit();
		session.close();
		
	}

	
	
	
	
	/**
	 * �����޸Ĳ���
	 * ֻ���ͻ��������ID��hiber����Դ�ID�����  ���˿ͻ���Ϊһ���µļ�¼���룬������¼Ҳ�����
	 */
	@Test
	public void test3(){
		
		//׼������
		//����һ���ͻ����Ŷ���
		Customer cust = new Customer();
		cust.setId(1);						//ֻ���ͻ��������ID
		cust.setName("С��");
		cust.setGender("Ů");
		
		
		Order o1 = new Order();
		o1.setOrderno("201709070003");
		o1.setProductName("��ƿ÷");
		
		Order o2 = new Order();
		o2.setOrderno("201709070004");
		o2.setProductName("����");
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//����һ�Զ�˫�������ϵ
		cust.getOrders().add(o1);
		cust.getOrders().add(o2);
		o1.setCustomer(cust);
		o2.setCustomer(cust);
		
		
		session.save(cust);
		session.save(o1);
		session.save(o2);
		
		tx.commit();
		session.close();
		
	}
	
	/**
	 * �����޸Ĳ���   ʧ�ܣ���Ϊ�¼�¼���
	 * ֻ�������������ID��hiber����Դ�ID�����  ���˿ͻ���Ϊһ���µļ�¼���룬��Ӧ�Ŀͻ���¼Ҳ�����
	 */
	@Test
	public void test4(){
		
		//׼������
		//����һ���ͻ����Ŷ���
		Customer cust = new Customer();

		cust.setName("С��");
		cust.setGender("��");
		
		
		Order o1 = new Order();
		o1.setId(1);
		o1.setOrderno("201709070005");
		o1.setProductName("��Ϣ��ʷ");
		
		Order o2 = new Order();
		o2.setId(2);
		o2.setOrderno("201709070006");
		o2.setProductName("���");
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//����һ�Զ�˫�������ϵ
		cust.getOrders().add(o1);
		cust.getOrders().add(o2);
		o1.setCustomer(cust);
		o2.setCustomer(cust);
		
		
		session.save(cust);
		session.save(o1);
		session.save(o2);
		
		tx.commit();
		session.close();
		
	}
	
	
	
	
	/**
	 * �����޸Ĳ���   ʧ��
	 * ����������Ϳͻ�����ͬʱ���ID��ʧ�ܣ��ͻ��Ͷ�����Ϣ��Ϊ�¼�¼�����
	 */
	@Test
	public void test5(){
		
		//׼������
		//����һ���ͻ����Ŷ���
		Customer cust = new Customer();
		cust.setId(1);
		cust.setName("С��");
		cust.setGender("��");
		
		
		Order o1 = new Order();
		o1.setId(1);
		o1.setOrderno("201709070007");
		o1.setProductName("ƽ��������");
		
		Order o2 = new Order();
		o2.setId(2);
		o2.setOrderno("201709070008");
		o2.setProductName("�ڶ���");
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//����һ�Զ�˫�������ϵ
		cust.getOrders().add(o1);
		cust.getOrders().add(o2);
		o1.setCustomer(cust);
		o2.setCustomer(cust);
		
		
		session.save(cust);
		session.save(o1);
		session.save(o2);
		
		tx.commit();
		session.close();
		
	}
	
	
	
	
	/**
	 * ������� - ��������
	 */
	@Test
	public void test6(){
		
		//׼������
		//����һ���ͻ����Ŷ���
		Customer cust = new Customer();
		cust.setName("С��");
		cust.setGender("Ů");
		
		
		Order o1 = new Order();
		o1.setOrderno("201709070001");
		o1.setProductName("JavaWeb�������");
		
		Order o2 = new Order();
		o2.setOrderno("201709070002");
		o2.setProductName("Spring�������");
		
		Order o3 = new Order();
		o3.setOrderno("201709070003");
		o3.setProductName("servlet��ʵս");
		
		Order o4 = new Order();
		o4.setOrderno("201709070004");
		o4.setProductName("hibernate��ԭ�����");
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		
		/*
		//����һ�Զ൥�������ϵ���ͻ�ֻ��������
		cust.getOrders().add(o1);
		cust.getOrders().add(o2);
		
		session.save(cust);//ʹ�ü������棨�뱣��ͻ���ʱ��ͬʱ���涩����
		�˵��������ϵ�ǿ��ͻ�ȥά�����������������ַ����˿ͻ���ά��Ȩ
		��ˣ�
		*/
		
		o1.setCustomer(cust);
		o2.setCustomer(cust);
		o3.setCustomer(cust);
		o4.setCustomer(cust);
		
		session.save(o1);
		session.save(o2);
		session.save(o3);
		session.save(o4);

		tx.commit();
		session.close();
		
	}
	
	
	/**
	 * ����ɾ��
	 * PS�����û�м���ɾ������ô��ɾ���ͻ���ʱ�򣬻�Ѷ������cust_id���ֵ����ΪNULL
	 * PS������м���ɾ������ô��ɾ���ͻ���ʱ�򣬻�Ѹÿͻ������ж���ɾ��
	 */
	@Test
	public void test7(){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.get(Customer.class, 2);
		session.delete(cust);
		tx.commit();
		session.close();
		
	}
	
	/**
	 * ���Լ��������� ʧ��  ��ʱδ֪
	 *	ֻ���ͻ������iD����Ч
	 */
	@Test
	public void test8(){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Customer cust = new Customer();
		cust.setId(1);
		cust.setName("С��");
		cust.setGender("Ů");
		
		
		
		Order o1 = new Order();
		o1.setOrderno("201709070003");
		o1.setProductName("JavaWeb�������1");
		
		Order o2 = new Order();
		o2.setOrderno("201709070004");
		o2.setProductName("Spring�������2");
		
		
		tx.commit();
		session.close();
		
	}

}
