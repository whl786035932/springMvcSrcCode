package cn.demo.disruptor;

import com.lmax.disruptor.EventFactory;
/**
 * 创建事件
 * @author whl
 *
 */
public class LongEventFactory implements EventFactory<LongEvent>{

	@Override
	public LongEvent newInstance() {
		return new LongEvent();
	}

	
}
