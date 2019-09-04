package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ProducerConsumerTester {

	
	public static void main(String[] args) {
		List<Integer> sharedQueue=new ArrayList<Integer>();
		int size=26;
		Thread prodThread = new Thread(new Producer(sharedQueue,size),"PRODUCER");
		Thread consThread = new Thread(new Consumer(sharedQueue,size),"CONSUMER");
		prodThread.start();
		consThread.start();
		
	}

}
