package thread.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest{

    Semaphore binary = new Semaphore(1);
  
    public static void main(String args[]) {
       // final SemaphoreTest test = new SemaphoreTest();
        ExecutorService ex = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
        	ex.execute(new Thread(){
        		@Override
        		public void run(){
        			new SemaphoreTest().mutualExclusion();
        		}
        	});
        }
   }
  
    private void mutualExclusion() {
        try {
            binary.acquire();
            //mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            binary.release();
            System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
        }
    } 
  
}

