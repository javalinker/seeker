package demo.service.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;
import org.springframework.util.Assert;

public class MyMessageCreator implements MessageCreator
{
    private String message;
    
    private String messageid;
    
    public MyMessageCreator(String message, String messageid){
        Assert.notNull(message, "Message must not be null");
        Assert.notNull(messageid, "Messageid must not be null");
        this.message = message;
        this.messageid = messageid;
    }
    
    @Override
    public Message createMessage(Session session) throws JMSException {
        Message msg = session.createTextMessage(message); 
        msg.setJMSMessageID(messageid);
        System.out.println("in sending, mid:" + msg.getJMSMessageID());
        System.out.println("in sending, msg:" + msg);
        return msg;
    }

    public String getMessageid()
    {
        return this.messageid;
    }

}
