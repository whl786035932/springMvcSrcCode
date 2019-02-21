package springmvcSrcCode.own;

import java.util.concurrent.DelayQueue;


public class Wangba implements Runnable{
	
	
	DelayQueue<Wangmin> que = new DelayQueue<Wangmin>();
	
	public void run() {
		try {
			while(true) {
				Wangmin take = que.take();
				xiaji( take);
			}
				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void shangji(String name, Integer id, Integer money) {
		Wangmin man = new Wangmin(id, name, money*1000+System.currentTimeMillis());
		System.out.println("网名"+man.getName()+" 身份证"+man.getId()+"交钱"+money+"块,开始上机..."); 
		que.add(man);
	}
	
	public void xiaji(Wangmin wangmin) {
		System.out.println("下机="+wangmin.toString());
	}
	
	public static void main(String args[]){  
//        try{  
//        	System.out.println("网吧开始营业");   
//            Wangba siyu = new Wangba();  
//            Thread shangwang = new Thread(siyu);  
//            shangwang.start();  
//              
//            siyu.shangji("路人甲", 123, 1);
//            siyu.shangji("路人乙", 234, 10);
//            siyu.shangji("路人丙", 345, 5);
//        }  
//        catch(Exception e){  
//            e.printStackTrace();
//        }
		
		
		Wangba wangba = new Wangba();
		Thread thread = new Thread(wangba);
		
		wangba.shangji("路人甲", 123,10);
		wangba.shangji("路人乙", 234,4);
		wangba.shangji("路人丁", 123, 3);
		wangba.shangji("路人丙", 456, 2);
		
		
		thread.start();
  
    }  
	
	
}
