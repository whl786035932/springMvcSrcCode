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
						System.out.println("************"+Thread.currentThread().getName()+"����---"+object);
					}
				});
			}else {
				service.submit(new Runnable() {
					
					@Override
					public void run() {
	                    long time = System.currentTimeMillis();
						messageQueue.put(String.valueOf(time));
						System.out.println(Thread.currentThread().getName()+" --������---"+time);
					}
				});
			}
			
		}
		
		service.shutdown();
		
		
//		final MessageQueue messageQueue = new MessageQueue();
//
//		ExecutorService service = Executors.newFixedThreadPool(20);
//		// ģ����̻߳�������д���ݵ�������ڶ����ݵ�����
//		// Ҳ����ģ��������������д����������ô���н��Ӧ���ǻ����empty
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
