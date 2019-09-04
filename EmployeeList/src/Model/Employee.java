package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Employee implements Comparable<Object>{

	private static int id;
	private String name;
	private String department;
	private Date dateOfJoining;
	private int age;
	private int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Employee(int id, String name, String department, Date dateOfJoining, int age, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.dateOfJoining = dateOfJoining;
		this.age = age;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	

	@Override
	public String toString() {
		System.out.printf("%-4d %-15s  %-30s  %-30s  %-10s  %-10s\n",this.id, this.name, 
				this.department,this.dateOfJoining.toString(),Integer.toString(this.age), Integer.toString(this.salary));
		String r="---next---";
		return r;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Employee employee=(Employee)o;
		if(this.salary==employee.salary) {
			return 0;
		}
		else if(this.salary>employee.salary) {
			return 1;
		}
		else {
		return -1;
		}
	}

	

}
