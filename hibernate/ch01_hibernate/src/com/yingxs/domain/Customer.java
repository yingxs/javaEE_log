package com.yingxs.domain;

import java.io.Serializable;
/**
 * �ͻ�ʵ����
 * @author admin
 *
 */
public class Customer implements Serializable {
	private Integer id;
	private String name;
	private String gender;
	private Integer age;
	private String level;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", level=" + level + "]";
	}
	
}
