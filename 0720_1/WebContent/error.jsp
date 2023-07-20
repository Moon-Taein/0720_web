<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 발생</title>
</head>
<body>
	<p>죄송합니다. 요청 처리 중 에러가 발생했습니다.</p>
	<p>관리자에게 연락 부탁</p>
	<%= exception.getMessage() %>
	<%= exception.getCause()   %>
	<%
		exception.printStackTrace();
		response.setStatus(500);
	%>
</body>
</html>