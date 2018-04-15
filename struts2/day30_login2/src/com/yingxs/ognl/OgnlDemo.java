package com.yingxs.ognl;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import org.junit.Test;

//Ŀ�꣺ѧϰ�˽�Ognl���ʽ�ĺ��Ķ���OgnlContext�����ʹ��
public class OgnlDemo {
	
	@Test
	public void test1(){
		User user = new User();
		user.setName("yingxs");
		user.setAge(20);
		
		//����һ��OgnlContext����
		OgnlContext context = new OgnlContext();
		//��user�������OgnlContext����
		context.put("user",user);
		//��OgnlContext������ȡ������
		User user2 = (User)context.get("user");
		System.out.println(user2.getName()+"\t"+user2.getAge());
	}
	
	//ʹ��Ognl���ʽȡ��OgnlContext�����ݣ�����ǷǸ���������ݣ���ô����ʹ��#
	@Test
	public void test2() throws OgnlException{
		User user = new User();
		user.setName("yingxs");
		user.setAge(20);
		
		//����һ��OgnlContext����
		OgnlContext context = new OgnlContext();
		//��user�������OgnlContext����
		context.put("user",user);		//��OgnlContext�ĸ����������
		
		//ʹ��ognl���ʽ��OgnlContext������ȡ������
		Object ognlObj = Ognl.parseExpression("#user.name");			//���ʽ����
		String name = (String)Ognl.getValue(ognlObj, context, context.getRoot());			//��ȡ���ݷ���
		System.out.println(name);
	}
	
	//ʹ��Ognl���ʽȡ��OgnlContext�����ݣ�����Ǹ���������ݣ���ô����Ҫʹ��#������Ҫkey����
	@Test
	public void test3() throws OgnlException{
		User user = new User();
		user.setName("yingxs");
		user.setAge(20);
		
		//����һ��OgnlContext����
		OgnlContext context = new OgnlContext();
		//��user�������OgnlContext����
		context.setRoot(user);		//��OgnlContext�ĸ����������
		
		//ʹ��ognl���ʽ��OgnlContext������ȡ������
		Object ognlObj = Ognl.parseExpression("age");			//���ʽ����
		Object name = (Object)Ognl.getValue(ognlObj, context, context.getRoot());			//��ȡ���ݷ���
		System.out.println(name);
	}
	
	//ʹ��Ognl���ʽ���þ�̬����
	@Test
	public void test4() throws OgnlException{
		//����һ��OgnlContext����
		OgnlContext context = new OgnlContext();
		
		//ʹ��ognl���ʽ��OgnlContext������ȡ������
//		Object ognlObj = Ognl.parseExpression("@java.lang.Math@round(10.5)");			//���ʽ����
		Object ognlObj = Ognl.parseExpression("@Math@round(10.5)");			//���ʽ����
		Object name = (Object)Ognl.getValue(ognlObj, context, context.getRoot());			//��ȡ���ݷ���
		System.out.println(name);

	}
	
}
