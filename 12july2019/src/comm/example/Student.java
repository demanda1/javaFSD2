package comm.example;

public class Student extends Person {
	
	private String stream;
	public Student() {
		super();  //calls the base class constructor
	}
	public Student (String stream) {
		super("Deepak", "jharkhand"); 
		this.stream=stream;
	}
	/*public String getStudentDetails() {
		return getDetails()+" stream:"+stream;
	}*/
	@Override
	protected String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails()+ "stream: "+stream;
	}
	
}
