package comm.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comm.example.factory.MyConnectionFactory;
import comm.example.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private MyConnectionFactory factory=null;
	private Connection connection=null;
	private PreparedStatement pStatement=null;
	private Statement statement =null;
	private ResultSet resultSet=null;
	
	public EmployeeDaoImpl() throws SQLException {
		// TODO Auto-generated constructor stub
		super();
		factory=MyConnectionFactory.createObject();
		connection=factory.getConnection();
	}

	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try {
			pStatement=connection.prepareStatement("INSERT into employee values(?,?,?,?)");
			pStatement.setInt(1, employee.getId());
			pStatement.setString(2, employee.getFirstName());
			pStatement.setString(3,  employee.getLastName());
			pStatement.setString(4, employee.getEmail());
			pStatement.executeUpdate();
	
		}
		catch(SQLException e) {
			System.out.println("duplicate id");
			
			e.printStackTrace();
		}finally {
			
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> list=new ArrayList<Employee>();
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT * from employee");
			while(resultSet.next()) {
				list.add(new Employee(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Employee> getEmployeeById(int id) {
		// TODO Auto-generated method stub
		List<Employee> list= new ArrayList<Employee>();
		try {
			pStatement=connection.prepareStatement("SELECT * from employee WHERE id=?");
			pStatement.setInt(1, id);
			resultSet=pStatement.executeQuery();
			while(resultSet.next()) {
				list.add(new Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		try {
			pStatement=connection.prepareStatement("DELETE from employee WHERE id=?");
			pStatement.setInt(1, id);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
