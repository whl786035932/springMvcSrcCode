package cn.demo.semaphore.design01;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQeue {
	private boolean freePrinters[]; // 存放打印机的状态，true表示空闲，false表示打印
	private Lock lockPrinters; //// 增加了锁，保证多个线程，只能获取得锁，才能查询哪台打印机空闲的
	private final Semaphore semaphore;
	public PrintQeue() {
		int printNum = 3;
		this.semaphore = new Semaphore(printNum);
		freePrinters = new boolean[printNum];

		for (int i = 0; i < printNum; i++) {
			freePrinters[i] = true; // 初始化时，默认所有的打印机都空闲
		}

		lockPrinters = new ReentrantLock();

	}

	private int getPrinter() {
		int ret = -1;
		try {
			lockPrinters.lock();// 先加锁，保证1次只能有1个线程来获取空闲的打印机
			for (int i = 0; i < freePrinters.length; i++) {
				// 遍历所有打印机的状态，发现有第1个空闲的打印机后，领取号码，
				// 并设置该打印机为繁忙状态（因为马上就要用它）
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 最后别忘记了解锁，这样后面的线程才能上来领号
			lockPrinters.unlock();
		}
		return ret;
	}

	public void printJob(Object document) {
		try {
			semaphore.acquire();
			// 去领号
			int assignerPrinter = getPrinter();

			long duration = (long) (1 + Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job in Printer%d during %d seconds\n",
					Thread.currentThread().getName(), assignerPrinter, duration);
			Thread.sleep(duration);
			freePrinters[assignerPrinter] = true; // 打印完以后，将该打印机重新恢复为空闲状态
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

}
