package Model;

import java.util.List;
import java.util.Set;

public class EmployeeBO {

	public EmployeeBO() {
		// TODO Auto-generated constructor stub
	}

	public static void printEmployee(Set<Object> employee) {
		for(Object obj:employee) {
			Employee e=(Employee)obj;
			System.out.println("EmployeeID  Name  Department  Date-Of-Joining  Age  Salary");
			//System.out.println(e.getId() + e.getName() +e.getDepartment() + e.getDateOfJoining() + e.getAge() + e.getSalary());
			System.out.println(e.toString());
		}
	}
	public static void printEmployee2(List<Object> employee) {
		for(Object obj:employee) {
			Employee e=(Employee)obj;
			System.out.println("EmployeeID  Name  Department  Date-Of-Joining  Age  Salary");
			//System.out.println(e.getId() + e.getName() +e.getDepartment() + e.getDateOfJoining() + e.getAge() + e.getSalary());
			System.out.println(e.toString());
		}
	}
}
