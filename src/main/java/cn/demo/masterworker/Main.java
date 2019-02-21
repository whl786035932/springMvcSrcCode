package cn.demo.masterworker;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Master master = new Master(new Worker(),10);
		Random random = new Random();
		
		for (int i = 0; i < 100; i++) {
			Task task = new Task();
			task.setId(i);
			task.setName("����"+i);
			task.setPrice(random.nextInt(1000));
			master.submit(task);
		}
		master.execute();
		
		long start = System.currentTimeMillis();
		while(true) {
			if(master.isComplete()) {
				
				long end = System.currentTimeMillis();
				long use=end-start;
				long result = master.getResult();
				System.out.println("���صĽ����result="+result+";��ʱ="+use);
				break;
			}
		}
		
		long end = System.currentTimeMillis();
		long result = master.getResult();
		System.out.println("���Main="+result+";��ʱ="+(end-start));
		
	}

}
