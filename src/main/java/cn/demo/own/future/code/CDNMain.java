package cn.demo.own.future.code;

public class CDNMain {
	public static void main(String[] args) {
		CdnTask cdnTask = new CdnTask();
		cdnTask.setValue(10);
		CdnData zhurucdn = new CdnClient().zhurucdn(cdnTask);
		System.out.println("主线程做其他事情");
		System.out.println(zhurucdn.zhurucdn());
	}

}
