package cn.demo.own.future.code;

public class CdnRealData implements CdnData{
	
	private String result;
	public CdnRealData(CdnTask task) {
		try {
			System.out.println("��ʼ������ҵ���߼�����");
			Thread.sleep(5000);
			this.result = task.getValue()*100+"";
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String zhurucdn() {
		return result;
	}
	
	

}
