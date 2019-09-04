package practice2;

public class Account {
	
	private String name; 
	private int amount;
	
	public Account(String name,int amount) {
		this.name=name;
		this.amount=amount;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public static void main(String args[]) {
		
		Account a1=new Account("deepak",878787);
		Account a2=new Account("sobhesh",676767);
		
		
		if(a1.equals(a2)) {
			System.out.println(true);
		}
		else{
			System.out.println(false);
		}
		
		if(a1==a2) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
	}
	
	
}
