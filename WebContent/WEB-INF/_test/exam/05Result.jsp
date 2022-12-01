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
<%@ include file = "../../_include/inc_header.jsp" %>

<h2>05Result</h2>

<table border="1">
	<tr>
		<td>이름</td>
		<td>
			${map.name }
			<hr>
			${fn:replace(map.name, ',','<br>') }
		</td>
	</tr>
	<tr>
		<td>성별</td>
		<td>${map.gender }</td>
	</tr>
	<tr>
		<td>연령대</td>
		<td>${map.aboutAge }</td>
	</tr>
	<tr>
		<td>관심분야</td>
		<td>
			${map.hobby }
			<hr>
			${fn:replace(map.hobby, ',','<br>') }
		</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${map.age }</td>
	</tr>
	<tr>
		<td>한마디</td>
		<td>${map.memo }</td>
	</tr>
	<tr>
		<td>생일</td>
		<td>${map.birthday }</td>
	</tr>
</table>
</body>
</html>
