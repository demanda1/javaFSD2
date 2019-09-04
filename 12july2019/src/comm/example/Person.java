package comm.example;

public class Person {
	private String name;
	private String address;

	//default constructor
	public Person() {
		this.name="sachin";
		this.address="mumbai";
		System.out.println("Inside person class default constructor");
	}
	
	//parameterized constructor
	public Person (String name,String  address ) {
		this.name=name;
		this.address=address;
		System.out.println("inside person class paramaterized constructor");
	}
	
	
	protected String getDetails() {
		return "name: "+name+"  address:  "+address;
	}

}
