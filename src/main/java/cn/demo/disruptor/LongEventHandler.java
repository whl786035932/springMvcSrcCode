package cn.demo.disruptor;

import com.lmax.disruptor.EventHandler;
/**
 * �¼�������
 * @author whl
 *
 */
public class LongEventHandler implements EventHandler<LongEvent>{

	@Override
	public void onEvent(LongEvent longEvent, long arg1, boolean arg2) throws Exception {
		System.out.println(longEvent.getValue());
	}

}
