package cn.demo.semaphore.design01;

public class Main {
	
	public static void main(String[] args) {
		PrintQeue printQeue = new PrintQeue();
		Job job = new Job(printQeue);
		Thread thread1 = new Thread(job);
		Thread thread2 = new Thread(job);
		Thread thread3 = new Thread(job);
		Thread thread4 = new Thread(job);
		Thread thread5 = new Thread(job);
		Thread thread6 = new Thread(job);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
	}

}
