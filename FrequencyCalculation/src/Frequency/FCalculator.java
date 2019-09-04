package Frequency;

import java.util.HashMap;
import java.util.Scanner;

public class FCalculator {
	
	private static String s;
	private static HashMap<String,String> hm=new HashMap();
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the String");
		s=scan.nextLine();
		
		for(int i=0;i<s.length();i++) {
			hm.put(String.valueOf(s.charAt(i)), String.valueOf(0) );
		}
		hm.forEach((k,v)->{
			int count=0;
			for(int i=0;i<s.length();i++) {
				if(hm.containsKey(String.valueOf(s.charAt(i)))) {
					count++;
				}
				hm.put(String.valueOf(s.charAt(i)), String.valueOf(count));
			}
			count=0;
		});
	}
}
