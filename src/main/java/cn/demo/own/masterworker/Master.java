package cn.demo.own.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.omg.PortableInterceptor.ForwardRequest;

public class Master {
	//任务队列
	private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<>();
	//存放多个worker的结果集，因为多个线程的并发操作，所以要用线程安全的ConcurrentHashMap
	private ConcurrentHashMap<String,Object> resultMap = new ConcurrentHashMap<>();
	//存放worker的对垒
	private Map<String,Thread> workers =new HashMap<String,Thread>();
	
	//添加任务
	public void submit(Task task) {
		taskQueue.add(task);
	}
	
	//启动所有的worker
	public void  execute() {
		Set<Entry<String, Thread>> entrySet = workers.entrySet();
		for (Entry<String, Thread> entry : entrySet) {
			Thread value = entry.getValue();
			value.start();
		}
	}
	
	//判断所有的任务是否结束
	public  boolean isComplete() {
		Set<Entry<String, Thread>> entrySet = workers.entrySet();
		
		for (Entry<String, Thread> entry : entrySet) {
			Thread value = entry.getValue();
			if(value.getState()!=Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}
	
	//对所有的任务的结果进行汇总
	public long getResult() {
		long result =0l;
		Set<Entry<String, Object>> entrySet = resultMap.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			Integer value = Integer.valueOf(String.valueOf(entry.getValue()));
			result+=value;
		}
		return result;
	}
	
	
	public Master(Worker worker, int workerCount) {
		worker.setTaskQueue(taskQueue);
		worker.setResutlMap(resultMap);
		for(int i=0;i<workerCount;i++) {
			Thread thread = new Thread(worker);
			workers.put("工作节点"+i, thread);
		}
	}
	
}
