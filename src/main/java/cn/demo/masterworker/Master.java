package cn.demo.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	//����������Ķ���
	private ConcurrentLinkedQueue<Task> taskque=new ConcurrentLinkedQueue<>();
	
	//����ͨ�Ķ��б������е�woker����
	private HashMap<String,Thread>  workers =new HashMap<>();
	
	//ConcurrentHashMap���̰߳�ȫ��
	//��Ҫһ��ConcurrentHashMapȥ��װÿһ��worker�Ĺ������,����ִ�У���Ҫһ���߲���������
	private ConcurrentHashMap<String, Object> resultMap=new ConcurrentHashMap<>();
	
	
	public Master(Worker worker,int workerCount) {
		//ÿһ��worker����Ҫ��master��taskQueue �����������ȡ��masterd��resultmap���ڽ�����ύ
		worker.setWorkQeue(this.taskque);
		worker.setResultMap(this.resultMap);
		for(int i=0;i<workerCount;i++) {
			//key��ÿ��worker�����֣�value��worker���̶߳���
			workers.put("�ֽڵ�"+i, new Thread(worker));
		}
		
	}
	
	//�ύ����
	public void submit(Task task) {
		taskque.add(task);
	}
	
	//��Ҫһ��ִ�з��������������е�worker����
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
