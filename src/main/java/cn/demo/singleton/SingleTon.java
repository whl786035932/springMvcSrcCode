package cn.demo.singleton;

/**
 * 通过静态内部类 全局共享，独一份；
 *
 * 2. 构造函数不暴露（如果暴露便不能保证一份），自己负责自己的构造；
 * 
 * @author whl
 *
 */
public class SingleTon {
	private static class SingletonHolder {
		private static SingleTon instance = new SingleTon();
	}

	private SingleTon() {

	}

	public static SingleTon getInstance() {
		return SingletonHolder.instance;
	}

}
