package cn.demo.collection;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
/**
 * wait notfiy ������wait�ͷ�����notfiy���ͷ���
 * @author alienware
 *
 */
public class ListAdd2 {
	private volatile static List list = new ArrayList();	
	
	public void add(){
		list.add("bjsxt");
	}
	public int size(){
		return list.size();
	}
	
	public static void main(String[] args) {
		
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.submit(new Callable<String>() {

			public String call() throws Exception {
				return null;
			}
		});
		final ListAdd2 list2 = new ListAdd2();
		
		// 1 ʵ��������һ�� lock
		// ��ʹ��wait �� notify ��ʱ�� �� һ��Ҫ�����synchronized�ؼ���ȥʹ��
		final Object lock = new Object();
		
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					synchronized (lock) {
						for(int i = 0; i <10; i++){
							list2.add();
							System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + "�����һ��Ԫ��..");
							Thread.sleep(500);
							if(list2.size() == 5){
								System.out.println("�Ѿ�����֪ͨ..");
//								countDownLatch.countDown();
								lock.notify();
							}
						}						
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				synchronized (lock) {
					if(list2.size() != 5){
						try {
							System.out.println("t2����...");
							lock.wait();
//							countDownLatch.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + "�յ�֪ͨ�߳�ֹͣ..");
					throw new RuntimeException();
				}
			}
		}, "t2");	
		
		t2.start();
		t1.start();
		
	}
	
}

