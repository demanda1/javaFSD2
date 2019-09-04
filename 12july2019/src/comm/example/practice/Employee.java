package comm.example.practice;

public class Employee {
	private int eid;
	private String fname;
	private String lname;
	private String dept;
	private int salary;
	
	public Employee() {
		
	}
	
	public Employee(int eid, String fname, String lname, String dept, int salary) {
		this.eid=eid;
		this.fname=fname;
		this.lname=lname;
		this.dept=dept;
		this.salary=salary;
	}
	
	protected String getDetails() {
		return "eid: "+ this.eid + " fname:" + this.fname +" "+this.lname + " dept:"+ this.dept + " salary: "+salary;
	}
	

}
