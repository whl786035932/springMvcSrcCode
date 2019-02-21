package cn.demo.own.future.code;

public class CdnClient {
	public CdnData zhurucdn(final CdnTask task) {
		final CdnFutrueData futureData = new CdnFutrueData();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				CdnRealData cdnRealData = new CdnRealData(task);
				futureData.setCdnRealData(cdnRealData);				
			}
		}).start();;
		return futureData;
	}

}
