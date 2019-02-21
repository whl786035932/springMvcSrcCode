import java.util.concurrent.CountDownLatch;

public class UseCountDownLatch {
	
	private static final CountDownLatch countDown=new CountDownLatch(2);
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("�߳�1  begin---");
					countDown.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("�߳�1  end---");
			}
		}).start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("�߳�2");
				countDown.countDown();
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("�߳�3");
				countDown.countDown();
			}
		}).start();
	}

}
