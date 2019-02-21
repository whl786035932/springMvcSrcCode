package springmvcSrcCode.own;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author lujianing01@58.com
 * @Description:
 * @date 2016/6/21
 */
public class DelayQueueTest {

	public static void main(String[] args) {
		DelayQueue<DelayedElement> delayQueue = new DelayQueue<DelayedElement>();

		// ������
		producer(delayQueue);

		// ������
		consumer(delayQueue);

		while (true) {
			try {
				TimeUnit.HOURS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ÿ100���봴��һ�����󣬷����ӳٶ��У��ӳ�ʱ��1����
	 * 
	 * @param delayQueue
	 */
	private static void producer(final DelayQueue<DelayedElement> delayQueue) {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					DelayedElement element = new DelayedElement(1000, "test");
					delayQueue.offer(element);
				}
			}
		}).start();

		/**
		 * ÿ���ӡ�ӳٶ����еĶ������
		 */
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						TimeUnit.MILLISECONDS.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("delayQueue size:" + delayQueue.size());
				}
			}
		}).start();
	}

	/**
	 * �����ߣ����ӳٶ����л������,���д���
	 * 
	 * @param delayQueue
	 */
	private static void consumer(final DelayQueue<DelayedElement> delayQueue) {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					DelayedElement element = null;
					try {
						element = delayQueue.take();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(System.currentTimeMillis() + "---" + element);
				}
			}
		}).start();
	}
}

class DelayedElement implements Delayed {

	private final long delay; // �ӳ�ʱ��
	private final long expire; // ����ʱ��
	private final String msg; // ����
	private final long now; // ����ʱ��

	public DelayedElement(long delay, String msg) {
		this.delay = delay;
		this.msg = msg;
		expire = System.currentTimeMillis() + delay; // ����ʱ�� = ��ǰʱ��+�ӳ�ʱ��
		now = System.currentTimeMillis();
	}

	/**
	 * ��Ҫʵ�ֵĽӿڣ�����ӳ�ʱ�� �ù���ʱ��-��ǰʱ��
	 * 
	 * @param unit
	 * @return
	 */
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	/**
	 * �����ӳٶ����ڲ��Ƚ����� ��ǰʱ����ӳ�ʱ�� - �Ƚ϶�����ӳ�ʱ��
	 * 
	 * @param o
	 * @return
	 */
	public int compareTo(Delayed o) {
		return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("DelayedElement{");
		sb.append("delay=").append(delay);
		sb.append(", expire=").append(expire);
		sb.append(", msg='").append(msg).append('\'');
		sb.append(", now=").append(now);
		sb.append('}');
		return sb.toString();
	}
}