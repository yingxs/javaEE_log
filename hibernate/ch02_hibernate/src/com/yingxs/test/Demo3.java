package com.yingxs.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.many2many.Role;
import com.yingxs.many2many.User;
import com.yingxs.utils.HibernateUtil;

/**
 * ��ʾ��Զ�Ĳ���
 * @author admin
 *
 */
public class Demo3 {
	
	
	/**
	 * ��Ӳ���
	 */
	@Test
	public void tes1(){
		/**
		 * ���󣺽��������û���������ɫ
		 */
		
		User u1 = new User();
		u1.setName("С��");
		
		User u2 = new User();
		u2.setName("С��");
		
		Role r1 = new Role();
		r1.setName("��������Ա");
		
		Role r2 = new Role();
		r2.setName("��ͨ����Ա");
		
		//����˫���ϵ
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		r1.getUsers().add(u1);
		r2.getUsers().add(u1);
		
		u2.getRoles().add(r2);
		r2.getUsers().add(u2);
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * ��ѯ����
	 */
	@Test
	public void tes2(){
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//��ѯһ���û������û����еĽ�ɫ
		User user = session.get(User.class, 1);
		Set<Role> roles = user.getRoles();
		System.out.println("��ǰ�û�Ϊ��"+user.getName()+"����ɫ�У�");
		for (Role role : roles) {
			System.out.println(role.getName());
		}
		tx.commit();
		session.close();
	}
	
	
	/**
	 * ������Ӳ���
	 */
	@Test
	public void tes3(){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setName("����");
		
		Role r = new Role();
		r.setName("����u����Ա");
		
		
		//������Ӳ���
		u.getRoles().add(r);
		
		session.save(u);
		
		
		tx.commit();
		session.close();
	}
	
	
	
	/**
	 * ����ɾ������
	 */
	@Test
	public void tes4(){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		/**
		 * ɾ���û�����ͬʱɾ���м���к��û���ص����ݣ���ɾ���˶�Ӧ�Ľ�ɫ����
		 * ��ʵ�ʿ����У��ڶ�Զ�Ĺ�ϵ�в�ʹ�ü���ɾ�� 
		 */
		User u = session.get(User.class, 3);
		session.delete(u);
		
		
		tx.commit();
		session.close();
	}
	
	
	

}
