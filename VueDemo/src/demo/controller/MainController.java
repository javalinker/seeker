package demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.model.User;

@Controller
@RequestMapping("/")
public class MainController
{
    @RequestMapping("/demo")
    public String test(){
        return "demo";
    }
    
    @RequestMapping(value="/getUser")
    @ResponseBody
    public User getUser(){
        User u = new User();
        u.setUsername("June");
        u.setPassword("123456");
        u.setAge(16);
        u.setAddress("xinhua Street #162, shenyang RPC");
        return u;
    }
    
    @RequestMapping("/getUserList")
    @ResponseBody
    public List<User> getUserList(){
        
        List<User> ul = new ArrayList<User>();
        
        User u1 = new User();
        u1.setUsername("June");
        u1.setPassword("123456");
        u1.setAge(16);
        u1.setAddress("xinhua Street #162, Shenyang RPC");
        
        User u2 = new User();
        u2.setUsername("Iron");
        u2.setPassword("abcdef");
        u2.setAge(24);
        u2.setAddress("sanlitun Street #465, Beijing RPC");
        
        ul.add(u1);
        ul.add(u2);
        return ul;
    }

}
