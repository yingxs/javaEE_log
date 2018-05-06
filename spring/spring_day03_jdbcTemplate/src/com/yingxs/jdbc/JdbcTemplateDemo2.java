package com.yingxs.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcTemplateDemo2 {
	
	
	
	
	//JDBCʵ��
	@Test
	public void testJDBC(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/spring_day03","root","123456");
			//��дsql���
			String sql = "select * from user where username=?";
			//Ԥ����sql
			psmt = conn.prepareStatement(sql);
			//���ò���ֵ
			psmt.setString(1, "lucy");
			//ִ��sql
			rs = psmt.executeQuery();
			//���������
			while(rs.next()){
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				
				System.out.println(user);
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	//1.��ѯ���ض���
	@Test
	public void testObject(){
		//1.1����������Դ�����������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3308/spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//1.2����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//����sql���
		String sql="select * from user where username=?";
		//1.3����jdbcTemplate��������ķ����õ���¼��
		//�ڶ��������ǽӿ�RowMapper
		User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(),"mary");
		System.out.println(user);
		
		
	}
	
	//1.��ѯ����list����
	@Test
	public void testList(){
		//1.1����������Դ�����������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3308/spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//1.2����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//����sql���
		String sql="select * from user";

		//�ڶ��������ǽӿ�RowMapper
		List<User> list = jdbcTemplate.query(sql, new MyRowMapper());
		
		System.out.println(list);
		
		
	}
	

	

}


class MyRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		//1.�ӽ�����õ�����
		String username = rs.getString("username");
		String password = rs.getString("password");
		
		//2.���õ������ݷ�װ����������
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		return user;
	}
	
}