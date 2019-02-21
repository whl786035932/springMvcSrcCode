package cn.demo.lock;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockCondition implements Runnable {

	public static ReentrantLock lock = new ReentrantLock(true);
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        lock.newCondition();
        try {
            lock.lock();
            System.err.println(Thread.currentThread().getName() + "-线程开始等待...");
            condition.await();
            System.err.println(Thread.currentThread().getName() + "-线程继续进行了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
    	TestLockCondition test = new TestLockCondition();
        Thread t = new Thread(test, "线程ABC");
        t.start();
        Thread.sleep(1000);
        System.err.println("过了1秒后...");
        lock.lock();
        condition.signal(); // 调用该方法前需要获取到创建该对象的锁否则会产生
                            // java.lang.IllegalMonitorStateException异常
        lock.unlock();
    }

}
