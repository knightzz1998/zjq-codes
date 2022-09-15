<%--
  Created by IntelliJ IDEA.
  User: knight'z'z
  Date: 2022/9/15
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- jstl 标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>学生</title>
	<%--
		http://localhost:8769/ssh/pages/css/student.css
	--%>
	<link href="${pageContext.request.contextPath}/pages/css/student.css" rel="stylesheet">
</head>
<body>

<h2 class="title">学生管理系统</h2>
<a>添加</a>
<table>
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>年龄</th>
	</tr>
	<c:forEach items="${students}" var="student">
		<tr>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.age}</td>
			<td><a href="#">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="#">删除</a></td>
		</tr>
	</c:forEach>

</table>

</body>
</html>
