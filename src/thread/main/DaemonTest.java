package thread.main;

import java.util.concurrent.TimeUnit;

public class DaemonTest implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			System.out.println("Finally block");
		}

	}

	public static void main(String args[]) throws InterruptedException {
		//for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new DaemonTest());
			t.setDaemon(true);
			t.start();
		//}
		System.out.println("All daemons started");
		//TimeUnit.MILLISECONDS.sleep(175);
	}

}
