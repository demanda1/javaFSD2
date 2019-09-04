package example1;

import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String args[]) {
		Set<Student> set= new TreeSet<Student>();
		
		set.add(new Student("A","B",2.9));
		set.add(new Student("A","B",4.3));
		set.add(new Student("A","B",4));
		set.add(new Student("A","B",3));
		Object[] obj=set.toArray();
		
		for(int i=0;i<obj.length;i++) {
			System.out.println(obj[i]);
		}
	}

}
