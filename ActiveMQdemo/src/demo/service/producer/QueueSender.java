package demo.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @description  队列消息生产者，发送消息到队列
 */
@Component("queueSender")
public class QueueSender {
	
	@Autowired
	@Qualifier("jmsQueueTemplate")
	private JmsTemplate jmsTemplate;//通过@Qualifier修饰符来注入对应的bean
	
	/**
	 * 发送一条消息到指定的队列（目标）
	 * @param queueName 队列名称
	 * @param message 消息内容
	 */
	public void send(String queueName,final String message, final String messageid){
	    MyMessageCreator mc = new MyMessageCreator(message, messageid);
		jmsTemplate.send(queueName, mc);
	}
	
}
