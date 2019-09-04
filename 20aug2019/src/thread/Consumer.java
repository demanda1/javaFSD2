package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Consumer implements Runnable{

	private final List<Integer> sharedQueue;
	private final int SIZE;
	
	public Consumer(List<Integer> sharedQueue, int SIZE) {
		// TODO Auto-generated constructor stub
		this.sharedQueue=sharedQueue;
		this.SIZE=SIZE;
	}
	
	public void run() {
		while(true) {
			try {
				for(int i=0;i<26;i++) {
					System.out.println("Consuming.."+ consume());
				}
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public synchronized int consume() throws InterruptedException{
	 synchronized(sharedQueue) {
		System.out.println(this.sharedQueue.size());
		while(this.sharedQueue.size()==0) {
			System.out.println("Queue is empty" + Thread.currentThread().getName()
					+" is waiting , size: "+ sharedQueue.size());
			
			sharedQueue.wait();
		}
		
		sharedQueue.notify();
		System.out.println("reached");
		return (Integer) this.sharedQueue.remove(0);
	}
  }

}
