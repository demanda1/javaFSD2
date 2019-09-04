package Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<String[]> state=new ArrayList<String[]>();
	
	private static List<Object> stateList=new ArrayList<Object>();
	private static List<Object> countryList=new ArrayList<Object>();
	private static State[] stateObj;
	private static Countries[] countryObj;
	
	public static void main(String args[]) {
		// TODO Auto-generated constructor stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Mention the no. of entries");
		int num=scan.nextInt();
		System.out.println("Enter the county|state");
		for(int j=0;j<num;j++) {
			String[] cs=scan.next().split("\\|",2);
			state.add(cs);  //list of country state arrays
		}
		Countries country=new Countries(state);
		for(String[] s:state) {
			country.addState(s[0],s[1]);
		}
		Countries.disp();
		
		
	}
}
