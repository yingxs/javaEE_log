package com.yingxs.test;
/**
 * ��ʾһ��һ��ϵ(��������)
 */
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yingxs.one2one_pk.Card;
import com.yingxs.one2one_pk.Person;
import com.yingxs.utils.HibernateUtil;

public class Demo5 {

	/**
	 * ��Ӳ���
	 */
	@Test
	public void test1(){
		Person p = new Person();
		p.setName("С��");
		
		Card c = new Card();
		c.setName("1001");
		
		c.setPerson(p);
		p.setCard(c);
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(p);
		session.save(c);

		
		tx.commit();
		session.close();
		
	}

}
