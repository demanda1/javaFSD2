package example1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Operation {

	public Operation() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]) {
		Set<Student> s=new TreeSet<Student>();
		Object[] obj;
		System.out.println("1.Add 2.Delete 3.Update");
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		if(choice==1){
			System.out.println("Enter first name , lastname and GPA");
			String fname=scan.next();
			String lname=scan.next();
			float gpa=scan.nextFloat();
			s.add(new Student(fname,lname,gpa));
			System.out.println("Successfully added");
			obj=s.toArray();
			for(Object o:obj) {
				System.out.println(o);
			}
		}
		else if(choice==2)
		{
			
		}
		else if(choice==3){
			
		}
	}

}
