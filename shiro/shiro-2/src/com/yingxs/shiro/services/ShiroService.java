package com.yingxs.shiro.services;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresRoles;


public class ShiroService {
	
	@RequiresRoles({"admin"})
	public void testMethod() {
		System.out.println("testMethod, time:"+new Date());
	}
	
	

}
