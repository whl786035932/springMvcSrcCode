package cn.demo.own.masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	private ConcurrentLinkedQueue<Task> taskQeue;
	private ConcurrentHashMap<String,Object> resultMap;
	@Override
	public void run() {
		while(true) {
			
			Task task = taskQeue.poll();
			if(task==null) {
				break;
			}
			Object result = handle(task);
			this.resultMap.put(task.getValue()+"", result);
		}
		
	}

	private Object handle(Task poll) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer value = poll.getValue();
//		System.out.println("接收到的任务value="+value);
		return value*value*value;
	}

	public void setTaskQueue(ConcurrentLinkedQueue<Task> taskQueue) {
		this.taskQeue=taskQueue;
		
	}

	public void setResutlMap(ConcurrentHashMap<String, Object> resultMap) {
		// TODO Auto-generated method stub
		this.resultMap=resultMap;
				
		
	}

}
