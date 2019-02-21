import java.util.Random;
import java.util.concurrent.Callable;

public class CallableChild implements Callable<String>{

	private String query;
	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+" 开始处理真实业务");
		Thread.sleep(new Random().nextInt(5000));
		return Thread.currentThread().getName()+" say Hello to "+query;
	}
	
	public CallableChild(String query) {
		this.query=query;
	}
	

}
