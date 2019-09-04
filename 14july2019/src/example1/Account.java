package example1;

import java.io.Serializable;
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2458127374975174319L;
	
	private String accountNumber;
	private double amount;
	
	public Account() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Account(String accountNumber, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}
	
	public Account createNewAccount(String accountNumber,double amount) throws AccountNotValidException{
		this.accountNumber=accountNumber;
		this.amount=amount;
		if(amount<10000) {
			throw new AccountNotValidException("Not a valid amount account");
		}
		return new Account(accountNumber,amount);
	}

}
