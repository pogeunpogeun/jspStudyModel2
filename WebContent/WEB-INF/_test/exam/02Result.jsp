<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file = "../../_include/inc_menu.jsp" %>

<form name="DirForm">
<table border="1">
	<tr>
		<td>이름</td>
		<td>${name }</td>
	</tr>
	<tr>
		<td>출생연도</td>
		<td>${year }</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${age }</td>
	</tr>
</table>
</form>
</body>
</html>
