package thread;

public class MyThreadDemo2 implements Runnable {

	public MyThreadDemo2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int j=0;j<20;j++) {
			if(j==10) {
				try {
					Thread.sleep(2000);
				}
				catch(InterruptedException i) {
					
				}
			}
			System.out.println("j ==> "+j);
		}
		
	}
	

}
