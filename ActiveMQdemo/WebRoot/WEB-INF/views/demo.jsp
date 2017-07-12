<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>demo</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script src="<c:url value='/resources/jquery-1.11.3.min.js' />"></script>
<script type="text/javascript">
  
  $(function(){
	  $(".btn_queue").click(function(){
		  $.ajax({
			  url: "queueSender.shtml",
			  data:{
				  queue: $(this).attr("data"),
				  message: $("#txt").val()
			  },
			  success: function(data){
				  $("#res").html(data);
			  },
			  error: function(data){
				  $("#res").html(data);
			  }
		  });
	  });
	  
	  $(".btn_topic").click(function(){
		  $.ajax({
			  url: "topicSender.shtml",
			  data:{
				  topic: $(this).attr("data"),
				  message: $("#txt").val()
			  },
			  success: function(data){
				  $("#res").html(data);
			  },
			  error: function(data){
				  $("#res").html(data);
			  }
		  });
	  });
  })
  
  
  </script>
</head>
<body>
  ActiveMQ demo 输入要发送的消息：
  <input id="txt">
  <br>
  <button class="btn_queue" data="q.ueue1">通过queueSender向queue1发送消息</button>
  <button class="btn_queue" data="q.ueue2">通过queueSender向queue2发送消息</button>
  <br>
  <button class="btn_queue" data="p.queue3">通过queueSender向queue3发送消息</button>
  <button class="btn_queue" data="p.queue4">通过queueSender向queue4发送消息</button>
  <br>
  <button class="btn_topic" data="topic1">通过TopicSender向topic1发送消息</button>
  <div id="res"></div>
</body>
</html>
