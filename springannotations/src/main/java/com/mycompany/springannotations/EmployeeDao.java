package com.mycompany.springannotations;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {
	
//	private DataSource datasource;
//
//	public EmployeeDao() {
//		super();
//	}
//
//	public DataSource getDatasource() {
//		return datasource;
//	}
//
//	public void setDatasource(DataSource datasource) {
//		this.datasource = datasource;
//	}
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void createEmployee(Employee employee) {
//		try {
//			Connection connection=datasource.getConnection();
//			PreparedStatement pst=connection.prepareStatement("insert into newemployee(name) values(?)");
//			pst.setString(1,employee.getName());
//			pst.executeUpdate();
//			System.out.println("inserted...!!");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		String query="insert into newemployee(name) values(?)";
		Object obj[]= {employee.getName()};
		jdbcTemplate.update(query,obj);
		System.out.println("done");
	}
	
}
