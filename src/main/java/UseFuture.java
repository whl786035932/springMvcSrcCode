import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class UseFuture implements Callable<String> {
	private String para;

	public UseFuture(String para) {
		this.para = para;
	}

	/**
	 * ��������ʵ��ҵ���߼�����ִ�п��ܺ���
	 */
	@Override
	public String call() throws Exception {
		// ģ��ִ�к�ʱ
		Thread.sleep(5000);
		String result = this.para + "�������";
		return result;
	}

	// �����ƺ���
	public static void main(String[] args) throws Exception {
		String queryStr = "query";
		// ����FutureTask�����Ҵ�����Ҫ��������ҵ���߼��������,����һ����ʵ����Callable�ӿڵ���
		FutureTask<String> future = new FutureTask<String>(new UseFuture(queryStr));

		FutureTask<String> future2 = new FutureTask<String>(new UseFuture(queryStr));
		// ����һ���̶��̵߳��̳߳����߳���Ϊ1,
		ExecutorService executor = Executors.newFixedThreadPool(2);
		// �����ύ����future,�����߳�ִ��RealData��call()����ִ��
		// submit��execute������ ��һ����submit���Դ���ʵ��Callable�ӿڵ�ʵ������ �ڶ�����submit�����з���ֵ

		Future f1 = executor.submit(future); // ��������һ���߳�ȥִ�е�
		Future f2 = executor.submit(future2);
		System.out.println("�������");

		try {
			// �����������������ݲ�����Ҳ����������ִ������ҵ���߼�
			System.out.println("����ʵ�ʵ�ҵ���߼�...");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ���û�ȡ���ݷ���,���call()����û��ִ�����,����Ȼ����еȴ�
		System.out.println("���ݣ�" + future.get());
		System.out.println("���ݣ�" + future2.get());

		executor.shutdown();
	}

}
