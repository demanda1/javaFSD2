package example2;

public class Tester2 {

	public static void main(String args[]) {
		Messaging m =Messaging.createMessagingObject("tom");
		System.out.println(m);
		Messaging m1=Messaging.createMessagingObject("harry");
		System.out.println(m.equals(m1));
		System.out.println(m.getMessage());
		System.out.println(m1.getMessage());
		System.out.println(m.createMessagingObject("tim"));
	}

}
