package cn.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockWait implements Runnable{
	private static ReentrantLock lock =new ReentrantLock();
	
	
	@Override
	public void run() {
		try {
			boolean tryLock = lock.tryLock(1, TimeUnit.SECONDS);
			if(tryLock) {
				System.out.println(Thread.currentThread().getName()+"或得锁");
				Thread.sleep(2000);
			}else {
				System.out.println(Thread.currentThread().getName()+"获取锁失败");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			if(lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
			
		}finally {
			lock.unlock();
		}
	}
	
	
	public static void main(String[] args) {
		TestLockWait testLockWait = new TestLockWait();
		Thread thread = new Thread(testLockWait);
		Thread thread2 = new Thread(testLockWait);
		
		thread.start();
		thread2.start();
		
		
	}

}
