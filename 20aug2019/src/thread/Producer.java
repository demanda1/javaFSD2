package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Producer implements Runnable {

	private final List<Integer> sharedQueue;
	private final int SIZE;
	public Producer(List<Integer> sharedQueue, int SIZE) {
		// TODO Auto-generated constructor stub
		this.sharedQueue=sharedQueue;
		this.SIZE=SIZE;
	}
	
	public void run() {
		while(true) {
			try {
				for(int j=0;j<26;j++) {
					System.out.println("Producing.."+produce(j));
				}
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
	public int produce(int i) throws InterruptedException{
		synchronized(sharedQueue) {
		System.out.println(this.sharedQueue.size());
			if(this.sharedQueue.size()==this.SIZE) {
				System.out.println("Queue id "+ Thread.currentThread().getName()+
						" is waitiing , size: "+ sharedQueue.size() );
				sharedQueue.wait();
			}
		
		
		sharedQueue.add(i);
		sharedQueue.notifyAll();
		return i;
	 }
	}

}
