package example3;

public class Tester3 {

	public static void main(String args[]) {
		ArrayDemo arrayDemo=new ArrayDemo();
		arrayDemo.createArray(26);
		char[] arr=arrayDemo.getArr();
		for(char c:arr) {
			System.out.print(c+" ");
		}
	}

}
