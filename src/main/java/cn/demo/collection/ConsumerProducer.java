package cn.demo.collection;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Queable;

public class ConsumerProducer {
	
	List<String> list = new ArrayList<String>();
	private int maxSize=5;
	
	class Producer extends Thread{
		public void produce(String object) {
			synchronized (list) {
				
				int size = list.size();
				if(size==maxSize) {
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					list.add(object);
					list.notify();
					
				}
			}
			
		}
		
		@Override
		public void run() {
		for(int i=0;i<10;i++) {
				produce("馒头"+i);
				System.out.println("生产馒头"+i);
			}
		}
		
	}

	
	
	
	class Consumer  extends Thread{
		public void consumer() {
			synchronized (list) {
				
				int size = list.size();
				if(size==0) {
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					String remove = list.remove(0);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					list.notify();
					System.out.println("消费"+remove);
				}
			}
			
		}
		
		@Override
		public void run() {
			while(true) {
				consumer();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		ConsumerProducer consumerProducer = new ConsumerProducer();
		Consumer consumer = consumerProducer.new Consumer();
		Producer producer = consumerProducer.new Producer();
		consumer.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producer.start();
		
	}
	
}
