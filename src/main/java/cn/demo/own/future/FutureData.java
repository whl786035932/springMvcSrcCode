package cn.demo.own.future;
/**
 * FutureData ��Future�Ĺؼ���ʵ������RealData�Ĵ�����װ��RealData�ĵȴ�����
 * @author whl
 *
 */
public class FutureData implements Data{
	
	private  RealData realData;
	
	boolean isReady =false;
	
	public synchronized void setRealData(RealData realData) {
		if(isReady) {
			return;
		}
		this.realData = realData;
		isReady=true;
		notify();
		
	}
	
	@Override
	public synchronized String getResult() {
		if(!isReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return realData.getResult();
	}

}
