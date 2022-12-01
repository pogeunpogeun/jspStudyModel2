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
<h2>직원관리_직원상세보기</h2>
	<table border="1" width="50%">
		<tr>
			<td>사번</td>
			<td>${dto.sabun }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<td>연락처</td>
			<td>${dto.phone }</td>
		</tr>
		<tr>
			<td>입사일</td>
			<td>${dto.hireDate }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${dto.email }</td>
		</tr>
		<tr>
			<td>연봉</td>
			<td>${dto.salary }</td>
		</tr>
		<tr>
			<td>부서</td>
			<td>${dto.buseoName }</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${dto.regiDate }</td>
		</tr>
	</table>
</body>
</html>
<div style="border: 0px solid red; width:50%; margin-top: 10px;" align="right">
|
<a href="#" onClick="move('list.do','');">목록</a>
|
<a href="#" onClick="move('chuga.do','');">등록</a>
|
<a href="#" onClick="move('sujung.do','${dto.sabun }');">수정</a>
|
<a href="#" onClick="move('sakje.do','${dto.sabun }');">삭제</a>
|
</div>
<script>
	function move(value1, value2) {
		location.href = '${path }/employee_servlet/' + value1 + "?sabun=" + value2;
	}
</script>