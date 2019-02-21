package cn.demo.masterworker;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Master master = new Master(new Worker(),10);
		Random random = new Random();
		
		for (int i = 0; i < 100; i++) {
			Task task = new Task();
			task.setId(i);
			task.setName("任务"+i);
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
				System.out.println("返回的结果是result="+result+";耗时="+use);
				break;
			}
		}
		
		long end = System.currentTimeMillis();
		long result = master.getResult();
		System.out.println("结果Main="+result+";耗时="+(end-start));
		
	}

}
