package example2;

public class NameNotMatched extends Throwable{

	private String message;
	public NameNotMatched() {
		// TODO Auto-generated constructor stub
	}
	public NameNotMatched(String message) {
		super();
		this.message = message;
		System.err.println(this.message);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
