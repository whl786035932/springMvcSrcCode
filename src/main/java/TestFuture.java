import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestFuture {
	public static void main(String[] args)  throws Exception{
		String query="whl";
		FutureTask<String> futureTask = new FutureTask<>(new CallableChild(query));
		FutureTask<String> futureTask2 = new FutureTask<>(new CallableChild(query));
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
		newFixedThreadPool.submit(futureTask);
		newFixedThreadPool.submit(futureTask2);
		
		System.out.println("开始处理主线程");
		Thread.sleep(100);
		System.out.println("主线程处理完毕");
		
		
		String string = futureTask.get();
		String string2 = futureTask2.get();
		System.out.println("----------"+string);
		System.out.println("----------"+string2);
		newFixedThreadPool.shutdown();
		
	}
}
