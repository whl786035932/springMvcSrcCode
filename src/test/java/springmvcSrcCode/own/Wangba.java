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
		System.out.println("����"+man.getName()+" ���֤"+man.getId()+"��Ǯ"+money+"��,��ʼ�ϻ�..."); 
		que.add(man);
	}
	
	public void xiaji(Wangmin wangmin) {
		System.out.println("�»�="+wangmin.toString());
	}
	
	public static void main(String args[]){  
//        try{  
//        	System.out.println("���ɿ�ʼӪҵ");   
//            Wangba siyu = new Wangba();  
//            Thread shangwang = new Thread(siyu);  
//            shangwang.start();  
//              
//            siyu.shangji("·�˼�", 123, 1);
//            siyu.shangji("·����", 234, 10);
//            siyu.shangji("·�˱�", 345, 5);
//        }  
//        catch(Exception e){  
//            e.printStackTrace();
//        }
		
		
		Wangba wangba = new Wangba();
		Thread thread = new Thread(wangba);
		
		wangba.shangji("·�˼�", 123,10);
		wangba.shangji("·����", 234,4);
		wangba.shangji("·�˶�", 123, 3);
		wangba.shangji("·�˱�", 456, 2);
		
		
		thread.start();
  
    }  
	
	
}
