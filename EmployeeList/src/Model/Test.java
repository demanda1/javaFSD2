package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) throws ParseException {
	
		Scanner scan=new Scanner(System.in);
		
		Set<Object> employee=new TreeSet<Object>();
		List<Object> employee2=new ArrayList<Object>();
		System.out.println("Enter the number of Employees");
		int numOfEmployees=scan.nextInt();
		for(int i=1; i<=numOfEmployees;i++) {
			int id=i;
			System.out.println("Enter Details of Employee"+i);
			String name=scan.next();
			String department=scan.next();
			String d=scan.next();
			int age=scan.nextInt();
			int salary=scan.nextInt();
			
			SimpleDateFormat sdfo=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sdfo.parse(d);
			
			employee.add(new Employee(id,name,department,date,age,salary));
			employee2.add(new Employee(id,name,department,date,age,salary));
		}
		System.out.println("1.Sort employees by salary");
		System.out.println("2.Sort employees by age and by date of joining");
		System.out.println("Enter your choice");
		int choice=scan.nextInt();
		switch(choice) {
		case 1: 
			EmployeeBO.printEmployee(employee);
			break;
		case 2:
			Collections.sort(employee2, new AgeComparator());
			EmployeeBO.printEmployee2(employee2);
		}
		
	
	}
	
}
