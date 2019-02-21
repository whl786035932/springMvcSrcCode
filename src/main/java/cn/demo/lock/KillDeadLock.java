package cn.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

public class KillDeadLock implements Runnable {
	private static ReentrantLock lock1 = new ReentrantLock();
	private static ReentrantLock lock2 = new ReentrantLock();

	private int lockFlag;

	@Override
	public void run() {
		try {
			if (lockFlag == 1) {
				lock1.lockInterruptibly();

				Thread.sleep(1000);
				lock2.lockInterruptibly();
				System.out.println(Thread.currentThread().getName()+"得到锁1"+lock1);
			}else {
				lock2.lockInterruptibly();
				Thread.sleep(2000);
				lock1.lockInterruptibly();
				System.out.println(Thread.currentThread().getName()+"得到锁2"+lock2);
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			if(lock1.isHeldByCurrentThread()) lock1.unlock();
			if(lock2.isHeldByCurrentThread()) lock2.unlock();
			 System.err.println(Thread.currentThread().getName() + "退出！");
		}

	}

	public KillDeadLock(int lockFlag) {
		this.lockFlag = lockFlag;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new KillDeadLock(1),"t1");
		Thread thread2 = new Thread(new KillDeadLock(2),"t2");
		
		thread.start();
		thread2.start();
		
		Thread.sleep(1000);
		
		thread2.interrupt();
		
		
		
		
		
	}

}
