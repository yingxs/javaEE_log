package com.yingxs.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ��ʽ����ͨ������ʷ�ʽ
 * @author admin
 *
 */
public class Demo2Action extends ActionSupport {
	
	
	public String save() {
		System.out.println("Demo1Action��save()����");
		return SUCCESS;
	}
	public String delete() {
		System.out.println("Demo1Action��update()����");
		return SUCCESS;
	}
	

}
