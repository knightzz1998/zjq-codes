<%--
  Created by IntelliJ IDEA.
  User: knight'z'z
  Date: 2022/11/22
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
	<title>Title</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	out.print(id);
	session.setAttribute("id", Integer.valueOf(id));
%>

<%--
	<%@ page isELIgnored="false" %> 必须加这个啊, 不然解析不了
--%>
<h2>2 ${sessionScope.id}</h2>


<a href="javascript:void(0)" onclick="toHelloServlet(${requestScope.id})"> 跳转到 HelloServlet </a>
<a href="hello-servlet"> 跳转到 HelloServlet2 </a>

<h1>hello</h1>

<script>

    function toHelloServlet(id) {
        console.log("................" + id)
    }
</script>

</body>
</html>