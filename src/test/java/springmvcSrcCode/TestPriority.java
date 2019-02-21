package springmvcSrcCode;

import java.util.concurrent.PriorityBlockingQueue;

import org.junit.Test;

public class TestPriority {
	
	@Test
	public void test() {
		PriorityBlockingQueue<Task> que = new PriorityBlockingQueue<Task>();
		Task task = new Task();
		task.setId(2);
		task.setName("任务1");
		que.add(task);
		
		
		Task task2 = new Task();
		task2.setId(1);
		task2.setName("任务2");
		
		que.add(task2);
		
		
		Task task3 = new Task();
		task3.setId(5);
		task3.setName("任务3");
		
		que.add(task3);
		
		for (Task taskin : que) {
			System.out.println(taskin.toString());
		}
		
		
		
	}
}



class Task implements Comparable<Task>{

	private int id;
	private String name ;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int compareTo(Task o) {
		return this.id>o.id?1:(this.id<o.id?-1:0);
	}
	
	@Override
	public String toString() {
		return   "id="+this.id+";name="+this.name;
	}
}
