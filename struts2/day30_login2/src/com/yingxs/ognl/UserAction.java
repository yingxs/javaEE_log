package com.yingxs.ognl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport {
	
	//�û���ÿ�η���action�����ҵ�񷽷�ʱ��struts2��ܻᴴ��ActionContext���� ��OgnlValueStack���󣩣�Action���󣩣�
	
	@Override
	public String execute() throws Exception {
		//1.��ȡActionContext����
		ActionContext ac = ActionContext.getContext();
		//2.��ActionContext�����ȡOgnlValueStack����
		ValueStack vs = ac.getValueStack();
		//3.�鿴OgnlValueStack����Ľṹ
		return super.execute();
	}
	
}
