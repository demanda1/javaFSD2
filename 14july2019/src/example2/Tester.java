package example2;

import java.util.Scanner;
public class Tester {

	public static void main(String args[]) {
		Person p=new Person();
		String fname[]=new String[2];
		String lname[]=new String[2];
		Person obj[]=new Person[2];
		Scanner s=new Scanner(System.in);
		try {
			for(int i=0;i<2;i++) {
				System.out.println("Enter fname");
				fname[i]=s.next();
				System.out.println("Enter lname");
				lname[i]=s.next();
				obj[i]=p.checkNames(fname[i], lname[i]);
				System.out.println("User created Successfully");
				System.out.println(obj[i].getFname());
				System.out.println(obj[i].getLname());
			}
		} catch (NameNotMatched e) {
			// TODO Auto-generated catch block
		}

		
	}

}
