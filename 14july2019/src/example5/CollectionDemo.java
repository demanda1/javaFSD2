package example5;
import java.util.Scanner;
import java.util.Set;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.HashSet;
public class CollectionDemo {

	static Scanner sc=new Scanner(System.in);
	private String str[];
	private Set<String> set;  // as collection can add any thing in it so to maintain data type integrity, we use generic type safety
	
	public CollectionDemo() throws InputMismatchException{
		System.out.println("nukmber of elments in the array: ");
	    str=new String[sc.nextInt()];
	    for(int i=0;i<str.length;i++) {
	    	System.out.print("Name: ");
	    	str[i]=sc.next().toString().toLowerCase();
	    }
	    set=new HashSet();
	    for(String s:str) {
	    	if(!set.add(s)) {
	    		System.out.println("Duplicate element found. Cannot add in the set"+ s);
	    	}
	    }
	}
	
	public void displayCollection() {
		System.out.println(set);
		for(String ss:set) {
			System.out.println(ss.toString());
		}
		/*Iterator<String> i=set.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().toString());
		}*/
	}
}
