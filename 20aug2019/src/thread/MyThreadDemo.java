package thread;

public class MyThreadDemo implements Runnable {

	public MyThreadDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		MyThreadDemo myThread= new MyThreadDemo();
		MyThreadDemo2 myThread2=new MyThreadDemo2();
		Thread t1=new Thread(myThread);
		Thread t2=new Thread(myThread2);
		t1.start();
		System.out.println(t1.isAlive());
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t2.isAlive());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		for(int i=0;i<20;i++) {
			System.out.println(" i ==> "+i);
			if(i==10) {
				Thread.sleep(2000);
				//Thread.yield(); //sleep by choice of processor
				
			}
		}
		}
		catch(Exception e){
			
		}
		
	}

}
