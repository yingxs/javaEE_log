package com.yingxs.action;

import com.opensymphony.xwork2.Action;

/**
 * Action�ĵڶ���д����ʵ��Action�ӿ�
 * �ô�:
 * 		1.�ṩĬ�ϵ�excute��������Action����ӹ淶
 * 		2.�ṩ��5�������г��õ���ͼ����
 * 	
 * @author admin
 *
 */
public class Demo2Action implements Action {
	
	@Override
	public String execute() throws Exception {
		System.out.println("Action�ĵڶ���д����ʵ��Action�ӿ�");
		return SUCCESS;
	}

	
	
}
