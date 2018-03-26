package com.yingxs.Threadlocation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yingxs.domain.Customer;
import com.yingxs.utils.HibernateUtil;

public class CustomerService {
	private CustomerDao dao = new CustomerDao();
	
	public void save(Customer c1,Customer c2){
		Session session = HibernateUtil.getSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		
		try {
			dao.save(c1);
//			int i = 100/0;		//��ʱ��������
			dao.save(c2);		
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			System.out.println("�������������Ѿ��ع�");
		}
	}

}
