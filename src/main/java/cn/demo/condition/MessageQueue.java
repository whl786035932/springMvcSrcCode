package cn.demo.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageQueue {
	private static final Lock lock = new ReentrantLock();
	private final Condition getAction = lock.newCondition();
	private final Condition putAction = lock.newCondition();
	private Object[] items = new Object[3];
	private int count = 0;
	private int putPosition = 0;
	private int getPosition = 0;

	public static void main(String[] args) {

	}

	public void put(Object object) {
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
//			System.out.println("put item is :" + object);
			getAction.signal();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public Object get() {
		Object object = null;
		lock.lock();
		try {
			while (count == 0) {
				getAction.await();
			}
			object = items[getPosition];
			
			if(getPosition==items.length-1) {
				getPosition =0;
			}
			getPosition++;
			count--;
			putAction.signal();
			return object;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return object;
	}

}
