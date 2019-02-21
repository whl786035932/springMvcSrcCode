package springmvcSrcCode;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.demo.service.UserService;

public class TestIOC {
	
	@Test
	public void test() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
		UserService bean = classPathXmlApplicationContext.getBean(UserService.class);
		bean.say();
	}
}
