import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclibarrierTest3 {
	static CyclicBarrier c = new CyclicBarrier(3);
	
	public static void main(String[] args)  throws Exception{
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					c.await();
					System.out.println("111111111111");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					c.await();
					System.out.println("2222222");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		});
		thread2.start();
		thread.start();
//		thread.interrupt();
		
		System.out.println("被阻塞的线程又="+c.getNumberWaiting());
//		
//		
		System.out.println(c.isBroken());
		
		
	}
}
