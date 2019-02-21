package cn.demo.disruptor;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

public class LongEventProducer {
	private final RingBuffer<LongEvent> ringBuffer;
	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer=ringBuffer;
	}
	
	public void onData(ByteBuffer bb) {
		long next = ringBuffer.next();
		try {
			LongEvent longEvent = ringBuffer.get(next);
			longEvent.setValue(bb.getLong(0));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ringBuffer.publish(next);
		}
	}

}
