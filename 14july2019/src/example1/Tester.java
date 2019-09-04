package example1;

import java.util.Scanner;
import java.util.InputMismatchException;
public class Tester {

	private static Scanner scanner=new Scanner(System.in);
	public static void main(String args[]) {
		
		String accountnumber=null;
			
		double amount=0;
		
		Account account=new Account();
		try {
			System.out.println("Account Number: ");
			accountnumber=scanner.next();
			System.out.println("amount: ");
			amount=scanner.nextDouble();
			
			account.createNewAccount(accountnumber, amount);
		}
		catch(AccountNotValidException e) {
			System.err.println(e.getMessage());
		}
		catch(InputMismatchException e) {
			System.err.println("amount must be numeric");
		}
	}

}
