package thread.main.waitandnotify;

public class Notifier implements Runnable {
	 
    private Message msg;
     
    public Notifier(Message msg) {
        this.msg = msg;
    }
 
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" started");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(Thread.currentThread().getName() +" Notifier work done");
                msg.notify();
                //msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
    }
 
}