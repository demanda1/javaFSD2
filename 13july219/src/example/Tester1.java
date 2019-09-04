package example;

public class Tester1 {
	
	public static void main(String args[]) {
		LivingThings livingThings =new Monkey("Tom");
		livingThings.walk();
		Dog dog=new Dog("A","B");
		dog.createLivingThings();
	}
}
