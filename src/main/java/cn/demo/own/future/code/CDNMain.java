package cn.demo.own.future.code;

public class CDNMain {
	public static void main(String[] args) {
		CdnTask cdnTask = new CdnTask();
		cdnTask.setValue(10);
		CdnData zhurucdn = new CdnClient().zhurucdn(cdnTask);
		System.out.println("���߳�����������");
		System.out.println(zhurucdn.zhurucdn());
	}

}
