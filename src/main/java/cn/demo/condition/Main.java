package cn.demo.condition;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static void main(String[] args) throws Exception {
//		final BJSXTMessageQueue messageQueue = new BJSXTMessageQueue();
		final MessageQueue messageQueue = new MessageQueue();
		ExecutorService service = Executors.newFixedThreadPool(20);
		for(int i=0;i<20;i++) {
			Thread.sleep(200);
			if(i%3==0) {
				service.submit(new Runnable() {
					
					@Override
					public void run() {
						Object object;
						object = messageQueue.get();
						System.out.println("************"+Thread.currentThread().getName()+"消费---"+object);
					}
				});
			}else {
				service.submit(new Runnable() {
					
					@Override
					public void run() {
	                    long time = System.currentTimeMillis();
						messageQueue.put(String.valueOf(time));
						System.out.println(Thread.currentThread().getName()+" --生产了---"+time);
					}
				});
			}
			
		}
		
		service.shutdown();
		
		
//		final MessageQueue messageQueue = new MessageQueue();
//
//		ExecutorService service = Executors.newFixedThreadPool(20);
//		// 模拟多线程环境，且写数据的请求多于读数据的请求
//		// 也可以模拟读数据请求多于写数据请求，那么运行结果应该是会出现empty
//		for(int i=0; i<20; i++){
//		    Thread.sleep(200);
//		    if(i %3 == 0){
//		        service.submit(new Runnable() {
//		            public void run() {
//		                try {
//		                    Object object = messageQueue.get();
//		                    System.out.println(object);
//		                } catch (Exception e) {
//		                    e.printStackTrace();
//		                }
//		            }
//		        });
//		    }else{
//		        service.submit(new Runnable() {
//		            public void run() {
//		                try {
//		                    long time = System.currentTimeMillis();
//		                    messageQueue.put(String.valueOf(time));
//		                } catch (Exception e) {
//		                    e.printStackTrace();
//		                }
//		            }
//		        });
//		    }
//		}
		
		
	}
}
