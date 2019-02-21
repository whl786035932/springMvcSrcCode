import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseCyclicBarrier2 {
	
	static class Runner implements Runnable{
		private  CyclicBarrier barrier;
		private String name;
		@Override
		public void run() {
			try {
				Thread.sleep(new Random().nextInt(5000));
				System.out.println(name+"准备ok");
				try {
					barrier.await();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name+"GO!");
		}
		
		public Runner(CyclicBarrier barrier, String name) {
			this.barrier=barrier;
			this.name = name;
		}
	}
	
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		Thread thread1 = new Thread(new Runner(cyclicBarrier, "zhangsan"));
		Thread thread2 = new Thread(new Runner(cyclicBarrier, "lisi"));
		Thread thread3 = new Thread(new Runner(cyclicBarrier, "wangwu"));
		newFixedThreadPool.submit(thread1);
		newFixedThreadPool.submit(thread2);
		newFixedThreadPool.submit(thread3);
		System.out.println("被阻塞的线程又="+cyclicBarrier.getNumberWaiting());
		newFixedThreadPool.shutdown();
		
		
	}
}
