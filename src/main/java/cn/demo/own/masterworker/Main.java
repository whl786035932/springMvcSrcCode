package cn.demo.own.masterworker;

public class Main {
	public static void main(String[] args) {
		Worker worker = new Worker();
		
		Master master = new Master(worker,10);
		
		for(int i=1;i<=600;i++) {
			Task task = new Task();
			task.setValue(i);
			master.submit(task);
		}
		
		master.execute();
		
		long start = System.currentTimeMillis();
		while(true) {
			if(master.isComplete()) {
				long end = System.currentTimeMillis();
				long result = master.getResult();
				System.out.println("���background="+result+";��ʱ="+(end-start));
				break;
			}
			
			
		}
		long end = System.currentTimeMillis();
		long result = master.getResult();
		System.out.println("���Main="+result+";��ʱ="+(end-start));
		
	}
}
