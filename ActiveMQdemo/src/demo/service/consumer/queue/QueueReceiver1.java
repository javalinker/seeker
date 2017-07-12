
package demo.service.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * @description  队列消息监听器
 */
@Component
public class QueueReceiver1 implements MessageListener {
    
    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;//通过@Qualifier修饰符来注入对应的bean

	@Override
	public void onMessage(Message message) {
		try {
		    System.out.println(message.getJMSDestination().toString());
			System.out.println("QueueReceiver1接收到消息:"+((TextMessage)message).getText());
			System.out.println("Qr1 JSM messageid :" + ((TextMessage)message).getJMSMessageID());
			System.out.println("Qr1 msg :" + ((TextMessage)message));
			//this.send("testResp", "Hi!");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * 发送一条消息到指定的队列（目标）
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void send(String queueName,final String message){
        jmsTemplate.send(queueName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
