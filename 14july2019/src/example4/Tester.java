package example4;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.err;
public class Tester {

	private static Scanner scanner=new Scanner(in);
	public static void main (String args[]) {
		String name=null;
		try {
			out.print("Coach Name: ");
			name=scanner.next();
			TennisCoach myCoach=new TennisCoach();
			myCoach.createCoach(name,Level.MEDIUM);
			out.println(myCoach.getCoachDetails().toString());
		}
		catch (InputMismatchException e){
			e.printStackTrace();
			err.println(e.toString());
		}
	}

}
