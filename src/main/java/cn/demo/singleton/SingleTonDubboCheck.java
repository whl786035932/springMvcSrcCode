package cn.demo.singleton;

public class SingleTonDubboCheck {
	private static  SingleTonDubboCheck instance=null;
	
	public static SingleTonDubboCheck getInstance() {
		if(instance==null) {
			synchronized(SingleTonDubboCheck.class) {
				instance=new SingleTonDubboCheck();
			}
		}
		return instance;
	}
}
