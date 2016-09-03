package thread.main;

public class WaitAndNotifyTest {
	public static void main(String args[]) {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		Thread t3 = new Thread();
		Thread t4 = new Thread();
		
	}

}

class Producer implements Runnable {
	public void run() {
		
	}
	
	public synchronized void print(){
		
	}

}

class Consumer implements Runnable {
	public void run() {

	}
	
	public synchronized void print(){
		
	}
}