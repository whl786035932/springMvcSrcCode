package cn.demo.own.future;

	
public class RealData implements Data{
	
	private String data;
	/**
	 * 获取真实的结果，是一个耗时的操作
	 */
	@Override
	public String getResult() {
		
		
		return data;
	}
	
	
	public RealData(String data) {
		try {
			System.out.println("真实的去处理业务");
			Thread.sleep(5000);
			System.out.println("后台处理任务完成");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.data=data;
	}
	
	

}
