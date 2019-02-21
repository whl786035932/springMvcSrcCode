package cn.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

import cn.videoworks.commons.util.concurrent.annotation.ThreadSafe;

public class TestRetrentLock implements Runnable{
	
	
	private  static ReentrantLock lock = new ReentrantLock();
	private  static int i =0;
	private boolean isRunning =true;
	@Override
	public void run() {
		lock.lock();
		for(int j=0;j<50;j++) {
			i++;
			System.out.println(Thread.currentThread().getName()+"----i="+i);
		}
		lock.unlock();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		TestRetrentLock testLock = new TestRetrentLock();
		Thread thread = new Thread(testLock);
		Thread thread2 = new Thread(testLock);
		thread.start();
		thread2.start();
		thread.join();
		thread2.join();
		
		
		
		System.out.println("main  i="+i);
		
		
		
	}

	
}
