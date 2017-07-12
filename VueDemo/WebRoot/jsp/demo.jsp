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
  <div id="app">
    <div>用户：<input v-model="user.username">{{ user.username }}</div>
    <div>密码：<input v-model="user.password">{{ user.password }}</div>
    <div>年龄：<input v-model="user.age">{{ user.age }}</div>
    <div>地址：<input v-model="user.address">{{ user.address }}</div>
  </div>
  <table id="app1">
    <tr>
      <th>用户名</th>
      <th>密码</th>
      <th>年龄</th>
      <th>地址</th>
    </tr>
    <tr v-for="item in items">
      <td>{{ item.username }}</td>
      <td>{{ item.password }}</td>
      <td>{{ item.age }}</td>
      <td>{{ item.address }}</td>
    </tr>
  </table>
  <button id="btn1">getUser</button>
  <button id="btn2">getUserList</button>
</body>
<script type="text/javascript">

	var app = new Vue({
		el : '#app',
		data : {
			user : {}
		}
	});

	var app1 = new Vue({
		el : '#app1',
		data : {
			items : []
		}
	})

	$(function() {

		$("#btn1").click(function() {
			$.ajax({
				url : "getUser.shtml",
				data : {},
				success : function(data) {
					var obj = eval('(' + data + ')');
					app.$data.user = obj;
				},
				error : function(data) {
					alert("get user error");
				}
			});
		});

		$("#btn2").click(function() {
			$.ajax({
				url : "getUserList.shtml",
				data : {},
				success : function(data) {
					var obj = eval('(' + data + ')');
					app1.$data.items = obj;
				},
				error : function(data) {
					alert("get user list error");
				}
			});
		});

	})
</script>
</html>
