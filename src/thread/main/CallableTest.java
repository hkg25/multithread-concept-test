package thread.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class CallableTest {

	public static void main(String args[]) {
		ExecutorService exService = Executors.newCachedThreadPool();
		Callable call = Executors.callable(new TaskWithResult(0));
		List<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			results.add(exService.submit(new TaskWithResult(i)));
		}

		for (Future<String> fs : results) {
			try {
				if (fs.isDone())
					System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				exService.shutdown();
			}
		}
		
		

		ExecutorService exService1 = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 6; i++) {
			exService1.execute(new LiftOff1());
		}

		exService1.shutdown();
		
		//Semaphore semaphore = new Semap

	}

}

class LiftOff1 implements Runnable {
	protected int countDown = 10; // Default
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff1() {
	}

	public LiftOff1(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!")
				+ "), ";
	}

	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}
}

class TaskWithResult implements Callable<String> {

	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		return "Result of taskresult : " + id;
	}

}
