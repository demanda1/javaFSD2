package comm.example.service;

import java.sql.SQLException;
import java.util.List;

import comm.example.dao.EmployeeDao;
import comm.example.dao.EmployeeDaoImpl;
import comm.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao dao=null;
	
	public EmployeeServiceImpl() throws SQLException {
		// TODO Auto-generated constructor stub 
		super();
		dao=new EmployeeDaoImpl();
	}

	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		dao.createEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

	@Override
	public List<Employee> getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeById(id);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		dao.deleteEmployee(id);
	}

}
