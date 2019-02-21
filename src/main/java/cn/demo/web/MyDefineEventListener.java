package cn.demo.web;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyDefineEventListener implements ApplicationListener<MyDefineEvent>{

	public void onApplicationEvent(MyDefineEvent event) {
		System.out.println("收到的事件="+event.getSource());
	}

}
