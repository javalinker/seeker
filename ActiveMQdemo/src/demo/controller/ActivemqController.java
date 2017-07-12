package demo.controller;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.service.producer.QueueSender;
import demo.service.producer.TopicSender;


/**
 * @description controller测试
 */
@Controller
@RequestMapping("/")
public class ActivemqController {
	
	@Resource 
	QueueSender queueSender;
	@Resource 
	TopicSender topicSender;
	
	@RequestMapping("demo")
	public String demo(){
	    return "demo";
	}
	
	/**
	 * 发送消息到队列
	 * Queue队列：仅有一个订阅者会收到消息，消息一旦被处理就不会存在队列中
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("queueSender")
	public String queueSender(@RequestParam("queue")String queue, @RequestParam("message")String message){
		String opt="";
		String messageid = "userid" + (Math.random() * 1000);
		try {
			queueSender.send(queue, message, messageid);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}
	
	/**
	 * 发送消息到主题
	 * Topic主题 ：放入一个消息，所有订阅者都会收到 
	 * 这个是主题目的地是一对多的
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("topicSender")
	public String topicSender(@RequestParam("topic")String topic, @RequestParam("message")String message){
		String opt = "";
		try {
			topicSender.send(topic, message);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}
	
	@RequestMapping(value="/push", produces="text/event-stream")
    @ResponseBody
    public String push(){
        Random r = new Random();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        String res = "data:Testing" + r.nextInt() + "\n\n";
        System.out.println("result :" + res);
        return res;
    }
	
    @RequestMapping("queueSender1")
    public void queueSender1(@RequestParam("queue")String queue, @RequestParam("message")String message){
        try {
            queueSender.send(queue, message, "123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        push();
    }
	
}
