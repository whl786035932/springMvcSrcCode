package cn.demo.semaphore;

import java.util.concurrent.Semaphore;

public class PrintQeue {
	private final Semaphore semaphore;
	
	public PrintQeue() {
		this.semaphore= new Semaphore(1);
	}
	
	
	public void printJob(Object document) {
		try {
		  semaphore.acquire();
			
		  long duration = (long) (1 + Math.random() * 10);
          System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), duration);
          Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
	}
	

}
