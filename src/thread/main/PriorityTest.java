package thread.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PriorityTest implements Runnable {

	private int priority;
	private int countDown = 5;
	private volatile double d;

	public PriorityTest(int prt) {
		this.priority = prt;
	}

	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}

	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
		while(true){
			for(int i=0;i<10000;i++){
				d += (Math.PI+Math.E)/(double) i;
				if(i%1000==0){
					Thread.yield();
				}
			}
			System.out.println(this);
			if(--countDown == 0) return;
		}
	}
	
	public static void main(String args[]){
		ExecutorService ex = Executors.newCachedThreadPool();
		
		for(int i=0;i<5;i++){
			ex.execute(new PriorityTest(Thread.MIN_PRIORITY));
		}
		//Thread.
		ex.execute(new PriorityTest(Thread.MAX_PRIORITY));
		ex.shutdown();
	}

}
