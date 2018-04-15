package com.yingxs.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yingxs.entity.User;

public class UserAction extends ActionSupport {
	
	private User user;
	

	public String register()  {
		System.out.println("������UserAction��register����");
		return SUCCESS;
	}
	
	
	
	public String login()  {
		if("yinxs".equals(user.getName()) && "123456".equals(user.getPassword())){
			
			
			//��¼�ɹ�
			//�������ݵ�session��
			ActionContext ac = ActionContext.getContext();
			Map<String, Object> sessionMap = ac.getSession();
			sessionMap.put("user", user);
			//��ת���û���ҳ
			return SUCCESS;
			
		}else{
			//��½ʧ��
			return ERROR;
		}
			
	}


	
	
	
	
	
	
	
	
	
	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
	
	
	
	
}
