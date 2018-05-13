package com.yingxs.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.yingxs.entity.User;

public class UserDaoImpl implements UserDao {
	
	//ע��hibernateTemplate����
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	public void add() {
		//HibernateTemplate��hibernate���з�װ
//		User user = new User();
//		user.setUsername("rose");
//		user.setAddress("japan");
//		
//		//����saveʵ�����
//		hibernateTemplate.save(user);
		
		//1.get����������id��ѯ
//		User user = hibernateTemplate.get(User.class, 2);
//		System.out.println(user.getUsername()+"::"+user.getAddress());
		
		
		//2. find������ѯ���м�¼
//		List<User> list =  (List<User>) hibernateTemplate.find("from User");
//		for (User user : list) {
//			System.out.println(user.getUsername()+"::"+user.getAddress());
//		}
		
		//3. find����������ѯ
		List<User> list =  (List<User>) hibernateTemplate.find("from User where username=?","lucy");
		for (User user : list) {
			System.out.println(user.getUsername()+"::"+user.getAddress());
		}
		
	}
}
