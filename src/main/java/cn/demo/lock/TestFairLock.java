package cn.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestFairLock implements Runnable {
	ReentrantLock lock = new ReentrantLock(true);
	private static int i=0;
	@Override
	public void run() {
		while(i<100) {
			try {
				i++;
				lock.lock();
				System.out.println(Thread.currentThread().getName()+"»ñµÃËø");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		TestFairLock testFairLock = new TestFairLock();
		Thread thread = new Thread(testFairLock,"t1");
		Thread thread2 = new Thread(testFairLock,"t2");
		
//		thread2.start();
//		thread.start();
		
		thread.start();
		thread2.start();
		
		
	}

}
