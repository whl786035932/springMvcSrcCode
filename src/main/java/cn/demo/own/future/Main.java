package cn.demo.own.future;

public class Main {
	public static void main(String[] args) {
		Client client = new Client();
		Data request = client.request("name");
		System.out.println("��ȥ����������������");
		System.out.println("��ȡ���Ľ��="+request.getResult());
	}
}
