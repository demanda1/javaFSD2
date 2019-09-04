package example2;

import java.io.Serializable;
public class Person implements Serializable{
	
	private String fname;
	private String lname;
	private static Person obj=null;
	private static Person obj2;
	private static int count=0;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String fname, String lname) {
		this.fname=fname;
		this.lname=lname;
	}
	
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public Person checkNames(String fname, String lname) throws NameNotMatched {
		if(!((fname.charAt(0)>=65 && fname.charAt(0)<91)&&(lname.charAt(0)>=65 && lname.charAt(0)<91))) {
			throw new NameNotMatched("Name not in format");
		}
		if(obj==null) {
			obj= new Person(fname,lname);
			return obj;
		}
		else {
			obj2=new Person(fname,lname);
			System.out.println(obj.getFname()+" "+obj2.getFname());
			if(obj.getFname().equals(obj2.getFname()) && obj.getLname().equals(obj2.getLname())) {
				System.out.println(obj);
				System.out.println(obj2);
				throw new NameNotMatched("User Already exists");
			}
			return obj2;
		}
	}

}
