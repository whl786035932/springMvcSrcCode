package cn.demo.own.future;

	
public class RealData implements Data{
	
	private String data;
	/**
	 * ��ȡ��ʵ�Ľ������һ����ʱ�Ĳ���
	 */
	@Override
	public String getResult() {
		
		
		return data;
	}
	
	
	public RealData(String data) {
		try {
			System.out.println("��ʵ��ȥ����ҵ��");
			Thread.sleep(5000);
			System.out.println("��̨�����������");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.data=data;
	}
	
	

}
