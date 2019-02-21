package springmvcSrcCode.own;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class Test {
	public static void main(String[] args) {
		new ReadWriteLock() {
			
			@Override
			public Lock writeLock() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Lock readLock() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		new Condition() {
			
			@Override
			public void signalAll() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void signal() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean awaitUntil(Date deadline) throws InterruptedException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void awaitUninterruptibly() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public long awaitNanos(long nanosTimeout) throws InterruptedException {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public boolean await(long time, TimeUnit unit) throws InterruptedException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void await() throws InterruptedException {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
