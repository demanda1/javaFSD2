package example1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ListDemo {

	public static void main(String args[]) {
		
		Collection<String> list=new ArrayList<String>();
		list.add("John");
		list.add("John");
		Set<String> set=new HashSet<String>();
		set.add("hello");
		set.add("world");
		list.addAll(set);
		System.out.println(list);
		list.removeAll(set);
		System.out.println(list);
		list.clear();
		System.out.println(list.isEmpty());
		for(String str:list) {
			//Cannot manipulate or use functions like has next here
		}
		Iterator<String> str=list.iterator();
		while(str.hasNext()) {
			list.remove(str.next());
		}
	}

}
