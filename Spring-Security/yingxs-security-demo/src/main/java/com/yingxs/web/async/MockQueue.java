package com.yingxs.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MockQueue {
	
	private String placeOrder;
	
	private String completerOrder;

	
	private Logger logger = LoggerFactory.getLogger(QueueListener.class);
	
	public String getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(String placeOrder) throws InterruptedException {
		
		new Thread( ()->{
			logger.info("接到下单请求,"+placeOrder);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.completerOrder = placeOrder;
			logger.info("下单请求处理完毕,"+placeOrder);
		}).start(); 
		
		
	}

	public String getCompleterOrder() {
		return completerOrder;
	}

	public void setCompleterOrder(String completerOrder) {
		this.completerOrder = completerOrder;
	}
	
	
	
	

}
