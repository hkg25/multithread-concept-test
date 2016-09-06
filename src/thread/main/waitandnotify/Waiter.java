package thread.main.waitandnotify;

public class Waiter implements Runnable {

	private Message msg;

	public Waiter(Message m) throws CloneNotSupportedException {
		this.msg = m;
		//this.clone();
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg) {
			try {
				System.out.println(name + " waiting to get notified at time:"
						+ System.currentTimeMillis());
				msg.wait(100);
				System.out.println("After wait thread executed   "  + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}