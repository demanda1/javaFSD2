package Password;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter password");
		String password=scan.next();
		UserMainCode pass=new UserMainCode();
		boolean val=pass.checkPassword(password);
		if(val) {
			System.out.println("Valid Password");
		}
		else {
			System.out.println("Invalid Password");
		}
	}
	
}
