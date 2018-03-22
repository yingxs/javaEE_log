package com.yingxs.many2many;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * �û�(�෽)
 * @author admin
 *
 */
public class User implements Serializable {
	private Integer id;
	private String name;
	
	//������ɫ
	private Set<Role> roles = new HashSet<Role>();
	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
