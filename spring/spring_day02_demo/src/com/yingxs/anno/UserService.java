package com.yingxs.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserService {
	
	//�õ�dao����
	//1.����dao���͵�����,����Ҫset����
	//2.��dao������ʹ��ע�⣬��ɶ���ע��
//	@Autowired
//	private UserDao userDao;
	
	//name����д����dao�����valueֵ
	@Resource(name="userDao123")
	private UserDao userDao;
	
	public void add(){
		System.out.println("service............");
		userDao.add();
	}

}
