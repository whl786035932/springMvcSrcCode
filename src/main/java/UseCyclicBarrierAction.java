import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class UseCyclicBarrierAction {
	
	static CyclicBarrier c = new CyclicBarrier(2, new Runer());
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"ready ");
				try {
					Thread.sleep(new Random().nextInt(5000));
					c.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" go ");
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"ready ");
				try {
					Thread.sleep(new Random().nextInt(5000));
					c.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" go ");
			}
		}).start();
//		try {
//			Thread.sleep(1000);
//			c.await();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (BrokenBarrierException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("-------2------");
	}
	
	static class Runer implements Runnable{

		@Override
		public void run() {
			System.out.println("----------3---------------");
		}}
	
}
