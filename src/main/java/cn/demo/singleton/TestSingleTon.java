package cn.demo.singleton;

import org.junit.Test;

public class TestSingleTon {

	@Test
	public void testStaticInnerClass() {
		SingleTon instance = SingleTon.getInstance();
		SingleTon instance2 = SingleTon.getInstance();
		System.out.println(instance==instance2);
	}
	
	@Test
	public void testDubboCheckSingleTon() {
		SingleTonDubboCheck instance = SingleTonDubboCheck.getInstance();
		SingleTonDubboCheck instance2 = SingleTonDubboCheck.getInstance();
		System.out.println(instance==instance2);
	}
	
	@Test
	public void testSingletonLazy() {
		SingletonLazy instance = SingletonLazy.getInstance();
		SingletonLazy instance_lazy = SingletonLazy.getInstance();
		System.out.println(instance==instance_lazy);
	}
}
