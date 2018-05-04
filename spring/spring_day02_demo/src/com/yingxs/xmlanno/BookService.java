package com.yingxs.xmlanno;

import javax.annotation.Resource;

public class BookService {
	
	//�õ�bookdao��ordersdao����
	
	@Resource(name="bookDao")
	private BookDao bookDao;
	
	@Resource(name="ordersDao")
	private OrdersDao ordersDao;
	
	
	public void add(){
		System.out.println("service.........");
		bookDao.book();
		ordersDao.buy();
	}

}
