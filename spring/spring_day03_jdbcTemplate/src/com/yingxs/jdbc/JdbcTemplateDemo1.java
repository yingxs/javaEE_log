package com.yingxs.jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {
	
	
	
	
	
	
	
	
	//1.��Ӳ���
	@Test
	public void add(){
		//1.1����������Դ�����������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3308/spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//1.2����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//1.3����jdbcTemplate��������ķ���ʵ�ֲ���
		//����sql���
		String sql="insert into user values(?,?)";
		int rows = jdbcTemplate.update(sql, "lucy","1");
		System.out.println(rows);
		
	}
	
	
	//2.�޸Ĳ���
	@Test
	public void update(){
		//2.1����������Դ�����������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3308/spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//2.2����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//2.3����jdbcTemplate��������ķ���ʵ�ֲ���
		String sql="update user set password=? where username=?";
		
		int rows = jdbcTemplate.update(sql, "300","yingxs");
		System.out.println(rows);
		
	}
	
	//3.ɾ������
	@Test
	public void delete(){
		//2.1����������Դ�����������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3308/spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//2.2����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//2.3����jdbcTemplate��������ķ���ʵ�ֲ���
		String sql="delete from user where username=?";
		
		int rows = jdbcTemplate.update(sql,"yingxs");
		System.out.println(rows);
		
	}
	
	
	

}
