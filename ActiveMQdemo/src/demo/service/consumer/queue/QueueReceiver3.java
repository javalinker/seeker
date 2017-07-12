package demo.service.consumer.queue;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class QueueReceiver3
{
    @Autowired
    private CachingConnectionFactory connectionFactory;
    
    public void receive(final String queueName) throws JMSException{
        
        Connection connection = connectionFactory.getTargetConnectionFactory().createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);
        MessageConsumer consumer = session.createConsumer(destination);
        Message message = consumer.receive();
        System.out.println(((TextMessage)message).getText());
        connection.stop();
    }

}
