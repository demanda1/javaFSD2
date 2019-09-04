package thread;

public class MyThreadDemo3 extends Thread {

	public MyThreadDemo3() {
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		System.out.println("hi");
	}
	
	public static void main(String[] args) {
		MyThreadDemo3 three =new MyThreadDemo3();
		three.start();
	}

}
