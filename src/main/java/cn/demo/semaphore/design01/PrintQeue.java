package cn.demo.semaphore.design01;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQeue {
	private boolean freePrinters[]; // ��Ŵ�ӡ����״̬��true��ʾ���У�false��ʾ��ӡ
	private Lock lockPrinters; //// ������������֤����̣߳�ֻ�ܻ�ȡ���������ܲ�ѯ��̨��ӡ�����е�
	private final Semaphore semaphore;
	public PrintQeue() {
		int printNum = 3;
		this.semaphore = new Semaphore(printNum);
		freePrinters = new boolean[printNum];

		for (int i = 0; i < printNum; i++) {
			freePrinters[i] = true; // ��ʼ��ʱ��Ĭ�����еĴ�ӡ��������
		}

		lockPrinters = new ReentrantLock();

	}

	private int getPrinter() {
		int ret = -1;
		try {
			lockPrinters.lock();// �ȼ�������֤1��ֻ����1���߳�����ȡ���еĴ�ӡ��
			for (int i = 0; i < freePrinters.length; i++) {
				// �������д�ӡ����״̬�������е�1�����еĴ�ӡ������ȡ���룬
				// �����øô�ӡ��Ϊ��æ״̬����Ϊ���Ͼ�Ҫ������
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ���������˽���������������̲߳����������
			lockPrinters.unlock();
		}
		return ret;
	}

	public void printJob(Object document) {
		try {
			semaphore.acquire();
			// ȥ���
			int assignerPrinter = getPrinter();

			long duration = (long) (1 + Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job in Printer%d during %d seconds\n",
					Thread.currentThread().getName(), assignerPrinter, duration);
			Thread.sleep(duration);
			freePrinters[assignerPrinter] = true; // ��ӡ���Ժ󣬽��ô�ӡ�����»ָ�Ϊ����״̬
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

}
