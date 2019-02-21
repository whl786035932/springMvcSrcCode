package cn.demo.own.future;

public class Main {
	public static void main(String[] args) {
		Client client = new Client();
		Data request = client.request("name");
		System.out.println("我去处理其他的事情了");
		System.out.println("获取到的结果="+request.getResult());
	}
}
