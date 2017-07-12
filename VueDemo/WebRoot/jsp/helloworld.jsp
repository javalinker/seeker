<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="<c:url value='/js/jquery-1.11.3.min.js' />"></script>
<script src="<c:url value='/js/vue.js' />"></script>
</head>
<body>
  <div id="app">{{ message }}</div>
  <div id="app-3">
    <p v-if="seen">现在你看到我了</p>
  </div>
  <div id="app-4" class="coo_css">
    <ol>
      <li v-for="todo in todos">{{ todo.text }}</li>
    </ol>
  </div>
</body>
<script type="text/javascript">
	var app = new Vue({
		el : '#app',
		data : {
			message : 'Hello Vue!'
		}
	})
	
	var app3 = new Vue({
		el : '#app-3',
		data : {
			seen : true
		}
	})
	
	var app4 = new Vue({
		  el: '.coo_css',
		  data: {
		    todos: [
		      { text: '学习 JavaScript' },
		      { text: '学习 Vue' },
		      { text: '整个牛项目' }
		    ]
		  }
		})
</script>
</html>
