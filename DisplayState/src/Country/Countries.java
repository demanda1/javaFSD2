package Country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Countries {
	
	private String name;
	private static List<String[]> states=new ArrayList<String[]>();
	private static TreeSet<String> ctry=new TreeSet<String>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Countries(List<String[]> states) {
		super();
		this.states=states;
	}
	
	public void addState(String country,String state) {
		ctry.add(country);
	}
	
	public static void disp() {
		
		int i=0;
		 ctry.forEach(val->{
			 TreeSet<String> stat=new TreeSet<String>();
			 for(String[] s:states) {

				 if(val.toString().equals(s[0].toString())) {
					stat.add(s[1]);
				 }
				 //System.out.println("===");
				}
			 System.out.println(val);
			 for(String s:stat) {
			  System.out.println("--"+s);
			 }
			 stat.clear();
		 });
			
	}
	
	
}
