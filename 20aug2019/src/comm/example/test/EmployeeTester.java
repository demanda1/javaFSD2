package comm.example.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import comm.example.model.Employee;
import comm.example.service.EmployeeService;
import comm.example.service.EmployeeServiceImpl;

public class EmployeeTester {

	private static Scanner scanner=new Scanner(System.in);

	public EmployeeTester() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws SQLException {
		EmployeeService service = new EmployeeServiceImpl();
		int choice=0;
		do {
			System.out.println("1.Create employee.");
			System.out.println("2.Display all employees");
			System.out.println("3. Display employee by id");
			System.out.println("4. Delete employee by id");
			System.out.println("0. Exit");
			System.out.println("Your Choice :");
			choice=scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Employee ID:");
				int id = scanner.nextInt();
				System.out.println("Employee First Name");
				String firstName = scanner.next();
				System.out.println("Employee Last Name ");
				String lastName = scanner.next();
				System.out.println("Employee Email: ");
				String email= scanner.next();
				service.createEmployee(new Employee(id, firstName, lastName, email));
				break;
			case 2:
				List<Employee> list=service.getAllEmployees();
				for(Employee e:list)
				{
					System.out.printf("%d  %s  %s  %s", e.getId(),e.getFirstName(), e.getLastName(), e.getEmail());
				}
				break;
			case 3:
				int id2=scanner.nextInt();
				List<Employee> list2=service.getEmployeeById(id2);
				for(Employee e:list2) {
					System.out.printf("%d  %s  %s  %s", e.getId(),e.getFirstName(), e.getLastName(), e.getEmail());
				}
				break;
			case 4:
				System.out.println("enter Id");
				int id3=scanner.nextInt();
				service.deleteEmployee(id3);
				break;
			case 0:
				System.out.println("Bye!");
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid Choice");
				break;
			}
			
				
		}while(choice!=0);
	}

}
