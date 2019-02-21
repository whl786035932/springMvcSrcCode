package cn.demo.masterworker;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable{
	
	private ConcurrentLinkedQueue<Task> taskque;
	
	private ConcurrentHashMap<String, Object> resultMap;
	
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Task input = this.taskque.poll();
			if(input==null) {
				break;
			}
			//真正地做任务处理
		Object output =	handle(input);
		this.resultMap.put(input.getId()+"", output);
		}
		
	}

	private Object handle(Task input) {
		// TODO Auto-generated method stub
		Object output = null;
		try {
			Thread.sleep(500);
			output = input.getPrice();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//表示处理业务的耗时，可能是查询数据库
		
		return output;
	}

	public void setWorkQeue(ConcurrentLinkedQueue<Task> taskque) {
		// TODO Auto-generated method stub
		this.taskque=taskque;
		
	}

	public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.resultMap=resultMap;
	}

}
