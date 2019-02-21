package cn.demo.singleton;

/**
 * ͨ����̬�ڲ��� ȫ�ֹ�����һ�ݣ�
 *
 * 2. ���캯������¶�������¶�㲻�ܱ�֤һ�ݣ����Լ������Լ��Ĺ��죻
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
