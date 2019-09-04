package practice3;

public class Main {
	public static void main(String args[]) {
		Product p=new Tv();
		System.out.println(Product.getItems());
	    p=new Book();
		System.out.println(Product.getItems());
	}
}
