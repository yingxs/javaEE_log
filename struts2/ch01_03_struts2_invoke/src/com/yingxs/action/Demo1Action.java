package com.yingxs.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ��ʽһ����ͳ���ʷ�ʽ
 * @author admin
 *
 */
public class Demo1Action extends ActionSupport {
	
	
	public String save() {
		System.out.println("Demo1Action��save()����");
		return SUCCESS;
	}
	public String update() {
		System.out.println("Demo1Action��update()����");
		return SUCCESS;
	}
	

}
