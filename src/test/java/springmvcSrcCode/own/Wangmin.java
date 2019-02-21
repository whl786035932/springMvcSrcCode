package springmvcSrcCode.own;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Wangmin implements Delayed{
	
	private Integer id;
	
	public Wangmin(Integer id, String name, long endTime) {
		this.id = id;
		this.name = name;
		this.endTime = endTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	private String name;
	
	private long endTime;

	public int compareTo(Delayed o) {
		Wangmin w = (Wangmin)o;  
        return this.getDelay(TimeUnit.SECONDS) - w.getDelay(TimeUnit.SECONDS) > 0 ? 1:0; 
	}

	public long getDelay(TimeUnit unit) {
		return endTime-System.currentTimeMillis();
	}
	
	@Override
	public String toString() {
		return this.id+";name="+this.name;
	}
	
}
