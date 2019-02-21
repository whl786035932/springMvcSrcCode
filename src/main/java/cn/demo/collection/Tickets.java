package cn.demo.collection;

import java.util.Vector;

public class Tickets {
	public static <E> void main(String[] args) {
		final Vector<String> tickets = new Vector();
		for(int i=1;i<=20;i++) {
			tickets.add("��Ʊ"+i);
		}
		Object object = new Object();
		for(int i=1;i<=10;i++) {
			 new Thread(new Runnable() {
				
				public void run() {
					while(true){
						if(tickets.isEmpty()) break;
						System.out.println(Thread.currentThread().getName() + "---" + tickets.remove(0));
					}
				}
			}).start();;
		}
		
		
//		for(int i=1;i<=10;i++) {
//			 new Thread(new Runnable() {
//				
//				public void run() {
//					synchronized(Tickets.class) {
//						
//						while(true){
//							int size = tickets.size();
//							if(size<100) {
//								tickets.add("��Ʊ"+size);
//								System.out.println(Thread.currentThread().getName() + "---" +"��Ʊ"+size );
//							}else {
//								break;
//							}
//						}
//					}
//				}
//			}).start();;
//		}
	}
}
