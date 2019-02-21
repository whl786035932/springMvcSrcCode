package cn.demo.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BJSXTMessageQueue {
	private static final Lock lock = new ReentrantLock();
	private final Condition getAction = lock.newCondition();
	private final Condition putAction = lock.newCondition();
	private Object[] items = new Object[3];
	private int count = 0;
	private int putPosition = 0;
	private int getPosition = 0;

	public void put(Object object) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length) {
				System.out.println("full");
				putAction.await();
			}
			items[putPosition] = object;
			if (putPosition == items.length - 1) {
				putPosition = 0;
			}
			putPosition++;
			count++;
			System.out.println("put time is: " + object);
			getAction.signal();
		} finally {
			lock.unlock();
		}
	}

	public Object get() throws InterruptedException {
		Object object = null;
		lock.lock();
		try {
			while (count == 0) {
				System.out.println("empty");
				getAction.await();
			}
			object = items[getPosition];
			if (getPosition == items.length - 1) {
				getPosition = 0;
			}
			getPosition++;
			count--;
			putAction.signal();
			return object;
		} finally {
			lock.unlock();
		}
	}

}
