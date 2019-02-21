package cn.demo.semaphore;

public class Main {
	
	public static void main(String[] args) {
		PrintQeue printQeue = new PrintQeue();
		Job job = new Job(printQeue);
		Thread thread1 = new Thread(job);
		Thread thread2 = new Thread(job);
		Thread thread3 = new Thread(job);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
