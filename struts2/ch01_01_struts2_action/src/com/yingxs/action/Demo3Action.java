package com.yingxs.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action�ĵ�����д�����̳�ActionSupport��
 * �ô�:
 * 		1.����Action�ӿڵ����кô�
 * 		2.��ӵ���������ܽӿ�
 * 	
 * @author admin
 *
 */
public class Demo3Action extends ActionSupport {
	
	@Override
	public String execute() throws Exception {

		System.out.println("Action�ĵ�����д�����̳�ActionSupport��");
		return SUCCESS;
	}
	
	
}
