package practice3;

public class Product {
	private int currentRate;
	
	private static int item ;
	private static final double TAX; //blank final variable
	
	public Product() {
		
	}
	static {
		item=0;
		TAX=12.36;
	}
	public Product(int currentRate) {
		item++;
		this.currentRate=currentRate;
	}

	public int getCurrentRate() {
		return currentRate;
	}

	public void setCurrentRate(int currentRate) {
		this.currentRate = currentRate;
	}
	
	public static int  getItems() {
		return item;
	}
	
}
