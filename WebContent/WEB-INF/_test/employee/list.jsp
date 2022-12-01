<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../_include/inc_menu.jsp" %>
<%@ include file = "../../_include/inc_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>직원관리_직원목록</h2>
list 길이 : ${fn:length(list) }
<hr>
<table border="1" width="50%">
	<tr>
		<th>사번</th>
		<th>이름</th>
		<th>부서</th>
	</tr>	
	<c:if test='${fn:length(list) == 0 }'>
	<tr>
		<td colspan="3" style="width:50%; height:100px;">
		등록된 사원이 없습니다.</td>
	</tr>
	</c:if>
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.sabun }</td>
		<td><a href="#" onClick="move('view.do','${dto.sabun }');">${dto.name }</td>
		<td>${dto.buseoName }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
<div style="border: 0px solid red; width:50%; margin-top: 10px;" align="right">
|
<a href="#" onClick="move('list.do','');">목록</a>
|
<a href="#" onClick="move('chuga.do','');">등록</a>
|
</div>
</body>
</html>
<script>
	function move(value1, value2) {
		location.href = '${path }/employee_servlet/' + value1 + "?sabun=" + value2;
	}
</script>