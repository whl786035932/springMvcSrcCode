package cn.demo.own.future.code;

public class CdnFutrueData implements CdnData {
	private CdnRealData cdnRealData;
	private boolean isReady;
	
	public synchronized void setCdnRealData(CdnRealData cdnRealData) {
		 if(isReady)
	            return;
		 this.cdnRealData = cdnRealData;
	        isReady = true;
	        notifyAll(); //Rea
	}
	@Override
	public synchronized String zhurucdn() {
		  if(!isReady) {
	            try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //һֱ�ȵ�RealDataע�뵽FutureData��
	        }
		return cdnRealData.zhurucdn();
	}

}
