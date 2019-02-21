package cn.demo.disruptor;

import java.nio.ByteBuffer;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

public class LongEventProducerWithTranslator {
	//һ��translator���Կ���һ���¼���ʼ������publicEvent�����������
    //���Event
    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR = 
            new EventTranslatorOneArg<LongEvent, ByteBuffer>() { 
                public void translateTo(LongEvent event, long sequence, ByteBuffer bb) { 
                    event.setValue(bb.getLong(0)); 
                } 
            };
    private final RingBuffer<LongEvent> ringBuffer;
    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) { 
        this.ringBuffer = ringBuffer; 
    } 
 
    public void onData(ByteBuffer bb) { 
        ringBuffer.publishEvent(TRANSLATOR, bb); 
    } 
}
