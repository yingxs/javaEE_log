package com.yingxs.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
	//ע��jdbcTemplate
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//�۳�
	public void lessMoney(){
		String sql = "update account set salary=salary-? where username=?";
		jdbcTemplate.update(sql, 1000,"С��");
	}
	
	//����
	public void moreMoney(){
		String sql = "update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql, 1000,"С��");
	}
	
	
	

}
