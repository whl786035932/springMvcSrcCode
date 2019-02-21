package cn.demo.own.future;

public class Client {
	
	public Data request(final String name) {
		final FutureData futureData = new FutureData();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				RealData realData = new RealData(name);
				futureData.setRealData(realData);
				
			}
		}).start();;
		return futureData;
	}

}
