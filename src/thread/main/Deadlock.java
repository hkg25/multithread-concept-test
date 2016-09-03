package thread.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Deadlock {

	 String str1 = "Java";
	 String str2 = "UNIX";
     
    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
            while(true){
                synchronized(str1){
                    synchronized(str2){
                        System.out.println(str1 + str2);
                    }
                }
            }
        }
    };
     
    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            while(true){
                synchronized(str2){
                    synchronized(str1){
                        System.out.println(str2 + str1);
                    }
                }
            }
        }
    };

	
	public static void main(String args[]) throws InterruptedException {
		
		ExecutorService exService = Executors.newCachedThreadPool();
		exService.execute(new Task("abnc"));
		
		
		
		
		Deadlock d1= new Deadlock();
		
		d1.trd1.start();
		d1.trd2.start();
		
		/*Thread t1 = new Thread(new Task("abc"));
		Thread t2 = new Thread(new Task("def"));
		t1.start();
		try{
			t1.wait(500);
		}catch(InterruptedException ex){
			System.out.println("Thread 1 interrupted");
		}
		t2.start();
*/		
	}

	public void accessResource() {

	}

}

class Task implements Runnable {

	private String caller;

	public Task(String caller) {
		this.caller = caller;
	}

	@Override
	public void run() {
		System.out.println("Caller: " + caller
				+ " and code on this Thread is executed by : "
				+ Thread.currentThread().getName());
	}

}