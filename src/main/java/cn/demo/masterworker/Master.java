package cn.demo.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	//工作的任务的队列
	private ConcurrentLinkedQueue<Task> taskque=new ConcurrentLinkedQueue<>();
	
	//用普通的队列保存所有的woker对象
	private HashMap<String,Thread>  workers =new HashMap<>();
	
	//ConcurrentHashMap是线程安全的
	//需要一个ConcurrentHashMap去承装每一个worker的工作结果,并行执行，需要一个高并发的容器
	private ConcurrentHashMap<String, Object> resultMap=new ConcurrentHashMap<>();
	
	
	public Master(Worker worker,int workerCount) {
		//每一个worker多需要有master的taskQueue 用于任务的提取，masterd额resultmap用于结果的提交
		worker.setWorkQeue(this.taskque);
		worker.setResultMap(this.resultMap);
		for(int i=0;i<workerCount;i++) {
			//key是每个worker的名字，value是worker（线程对象）
			workers.put("字节点"+i, new Thread(worker));
		}
		
	}
	
	//提交任务
	public void submit(Task task) {
		taskque.add(task);
	}
	
	//需要一个执行方法，用来让所有的worker启动
	public void  execute() {
		for(Map.Entry<String, Thread> me: workers.entrySet()) {
			Thread value = me.getValue();
			value.start();
		}
	}

	public boolean isComplete() {
		for(Map.Entry<String, Thread> me: workers.entrySet()) {
			if(me.getValue().getState()!=Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}

	public long getResult() {
		long result=0l;
		for(Map.Entry<String, Object> me: resultMap.entrySet()) {
			Integer value = Integer.valueOf(String.valueOf( me.getValue()));
			result+=value;
			
		}
		return result;
	}
}
