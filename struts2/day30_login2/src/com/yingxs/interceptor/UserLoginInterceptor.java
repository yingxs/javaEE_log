package com.yingxs.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.yingxs.entity.User;

public class UserLoginInterceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		/*
		 * ���⣺������������Ҫ���ص�¼(login)��ע��(register)����
		 */
		//�õ���ǰ���ص�Ŀ��Action�Ĵ������
		ActionProxy actionProxy = arg0.getProxy();
		//�õ���ǰִ�е�Action������
		String method = actionProxy.getMethod();
		
		if("login".equals(method) || "register".equals(method)){
			//����
			return arg0.invoke();
		}
		
		//1.��ȡsession�е�����
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> sessionMap = ac.getSession();
		User user = (User)sessionMap.get("user");
		//2.�ж�session�е������Ƿ����
		if(user==null){
			//�����ھ���ת����¼ҳ��
			return "login";
		}else{
			//���ھͷ���
			return arg0.invoke();
		}
	}

}
