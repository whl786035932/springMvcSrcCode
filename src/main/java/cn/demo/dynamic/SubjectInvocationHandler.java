package cn.demo.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectInvocationHandler implements InvocationHandler{
	
	private Object object;
	
	public SubjectInvocationHandler(Object object) {
		this.object= object;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("SubjectInvocationHandler     proxy-------------before");
		method.invoke(object, args);
		System.out.println("SubjectInvocationHandler  proxy  ----------after");
		return object ;
	}

}
