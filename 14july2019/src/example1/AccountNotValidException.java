package example1;

public class AccountNotValidException extends Throwable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3951719343280302001L;
	private String message;
	
	public AccountNotValidException() {
		super();
	}
	
	public AccountNotValidException(String e) {
		super();
		this.setMessage(e);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
