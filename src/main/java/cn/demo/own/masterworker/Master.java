package cn.demo.own.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.omg.PortableInterceptor.ForwardRequest;

public class Master {
	//�������
	private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<>();
	//��Ŷ��worker�Ľ��������Ϊ����̵߳Ĳ�������������Ҫ���̰߳�ȫ��ConcurrentHashMap
	private ConcurrentHashMap<String,Object> resultMap = new ConcurrentHashMap<>();
	//���worker�Ķ���
	private Map<String,Thread> workers =new HashMap<String,Thread>();
	
	//�������
	public void submit(Task task) {
		taskQueue.add(task);
	}
	
	//�������е�worker
	public void  execute() {
		Set<Entry<String, Thread>> entrySet = workers.entrySet();
		for (Entry<String, Thread> entry : entrySet) {
			Thread value = entry.getValue();
			value.start();
		}
	}
	
	//�ж����е������Ƿ����
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
	
	//�����е�����Ľ�����л���
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
			workers.put("�����ڵ�"+i, thread);
		}
	}
	
}
