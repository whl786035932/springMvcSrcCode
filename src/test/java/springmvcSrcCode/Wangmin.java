package springmvcSrcCode;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Wangmin implements Delayed {  
    
    private String name;  
    //闊偂鍞ょ拠锟�  
    private String id;  
    //閹搭亝顒涢弮鍫曟？  
    private long endTime;  
    //鐎规矮绠熼弮鍫曟？瀹搞儱鍙跨猾锟�
    private TimeUnit timeUnit = TimeUnit.SECONDS;
      
    public Wangmin(String name,String id,long endTime){  
        this.name=name;  
        this.id=id;  
        this.endTime = endTime;  
    }  
      
    public String getName(){  
        return this.name;  
    }  
      
    public String getId(){  
        return this.id;  
    }  
      
    /** 
     */  
    public long getDelay(TimeUnit unit) { 
        //return unit.convert(endTime, TimeUnit.MILLISECONDS) - unit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    	return endTime - System.currentTimeMillis();
    }  
  
    /** 
     */  
    public int compareTo(Delayed delayed) {  
    	Wangmin w = (Wangmin)delayed;  
        return this.getDelay(this.timeUnit) - w.getDelay(this.timeUnit) > 0 ? 1:0;  
    }  
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}  