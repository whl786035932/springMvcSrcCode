package springmvcSrcCode;

import java.util.concurrent.PriorityBlockingQueue;

import org.junit.Test;

import cn.demo.reflect.Fruit;
import cn.demo.reflect.FruitFactory;

public class TestReflect {

	
	@Test
	public void testFactory() {
		Fruit instance = FruitFactory.getInstance("Apple");
		instance.eat();
		Fruit instance2 = FruitFactory.getInstance("Orange");
		instance2.eat();
	}
	
	@Test
	public void testReflect() {
		Fruit instance_apple= FruitFactory.getInstance_className("cn.demo.reflect.Apple");
		Fruit instance_orange = FruitFactory.getInstance_className("cn.demo.reflect.Orange");
		
		Fruit instance_apple2= FruitFactory.getInstance_className("cn.demo.reflect.Apple");
		
		
		instance_apple.eat();
		instance_orange.eat();
	}
	@Test
	public void testPri() {
		PriorityBlockingQueue<String> que = new PriorityBlockingQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		System.out.println(que.size());
	}
	
	
}
