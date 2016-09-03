package thread.main;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

import thread.main.waitandnotify.Message;

public class Snippet {
	public static void main(String[] args) {
		//CopyOnWriteArrayListTest
		
		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		// does not support null keys
		//concurrentHashMap.put(null, "A");
		
		concurrentHashMap.put("X", "A");
		
		// does not support null values
		//concurrentHashMap.put("Z", null);
		
		System.out.println(concurrentHashMap);
		
		
		int i = 3 & 22;
		
		System.out.println(i);
		
		Message msg = new Message("I am in");
		
		System.out.println(msg.hashCode());
		
		SoftReference<Message> soft = new SoftReference<>(msg);
		
		msg = null;
		
		System.out.println(soft.get().hashCode());
	}
}

