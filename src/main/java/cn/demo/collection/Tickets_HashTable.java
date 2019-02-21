package cn.demo.collection;

import java.util.Hashtable;

public class Tickets_HashTable {
	
	public static void main(String[] args) {
		final Hashtable tickets=new Hashtable<Integer, String>();
		
		
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {
				
				public void run() {
					synchronized (Tickets_HashTable.class) {
						while(true) {
							int size = tickets.size();
							if(size<=20) {
								tickets.put(size, "»ð³µÆ±"+size);
								System.out.println(Thread.currentThread().getName()+"---»ð³µÆ±"+size);
							}else {
								break;
							}
						}
					}
				}
			}).start();;
		}
	}
}
