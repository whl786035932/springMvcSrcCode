package cn.demo.semaphore;

public class Job implements Runnable{

	private PrintQeue printQeue;
	@Override
	public void run() {
		 System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
		 printQeue.printJob(new Object());
	      System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
		
	}
	
	public Job(PrintQeue printQeueu) {
		this.printQeue = printQeueu;
	}
	
	
}
