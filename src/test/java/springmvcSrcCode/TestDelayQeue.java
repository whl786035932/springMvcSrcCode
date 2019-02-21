package springmvcSrcCode;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import springmvcSrcCode.own.Wangba;

public class TestDelayQeue {
	
	public static void main(String[] args) {
		
		Wangba wangba = new Wangba();
		Thread thread = new Thread(wangba);
		
		wangba.shangji("路人甲", 123, 10);
		wangba.shangji("路人乙", 234, 1);
		wangba.shangji("路人丙", 456, 3);
		thread.start();
	}
	
}






