package com.yingxs.service;

import com.yingxs.dao.OrderDao;

public class OrderService {

	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	public void accountMoney(){
		//С���۳�1000
		orderDao.lessMoney();
		int i=1/0;
		//С������1000
		orderDao.moreMoney();
	}
}



