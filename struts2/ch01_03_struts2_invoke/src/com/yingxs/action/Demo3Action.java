package com.yingxs.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ��ʽ������̬�������ʷ�ʽ
 * @author admin
 *
 */
public class Demo3Action extends ActionSupport {
	
	
	public String save() {
		System.out.println("Demo3Action��save()����");
		return SUCCESS;
	}
	public String delete() {
		System.out.println("Demo3Action��update()����");
		return SUCCESS;
	}
	

}
