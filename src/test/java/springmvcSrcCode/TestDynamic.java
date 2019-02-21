package springmvcSrcCode;

import java.lang.reflect.Proxy;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;

import cn.demo.dynamic.RealSubject;
import cn.demo.dynamic.Subject;
import cn.demo.dynamic.SubjectInvocationHandler;

public class TestDynamic {
	
	@Test
	public void test() {
		RealSubject realSubject = new RealSubject();
		Class<?>[] interfaces = realSubject.getClass().getInterfaces();
		
		SubjectInvocationHandler invocationHandler = 	new SubjectInvocationHandler(realSubject);
		Subject newProxyInstance = (Subject) Proxy.newProxyInstance(SubjectInvocationHandler.class.getClassLoader(), interfaces, invocationHandler);
		System.out.println(newProxyInstance.getClass().getName());
		newProxyInstance.rent();
		
		
	}

}
