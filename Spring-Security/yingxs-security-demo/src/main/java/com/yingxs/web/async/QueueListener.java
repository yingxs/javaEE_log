package com.yingxs.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private MockQueue mockQueue;
	
	private Logger logger = LoggerFactory.getLogger(QueueListener.class);
	@Autowired
	private DeferredResultHolder deferredResultHolder;


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		new Thread(() ->  { 
			while(true) {
				if (StringUtils.isNotBlank(mockQueue.getCompleterOrder())) {
					String orderNumber = mockQueue.getCompleterOrder();
					logger.info("返回订单处理结果: "+orderNumber);
					deferredResultHolder.getMap().get(orderNumber).setResult("place order success");
					mockQueue.setCompleterOrder(null);
				} else {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		} ).start();; 
		
	}
	

}
