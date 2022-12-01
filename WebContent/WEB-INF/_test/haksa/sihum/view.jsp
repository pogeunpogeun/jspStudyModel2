<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "../../../_include/inc_menu.jsp" %>
<h2>학사관리_시험상세보기</h2>
<table border="1" width="80%">
	<tr>
		<td width="100px">시험번호</td>
		<td>${dto.sihumNo }</td>
	</tr>
	<tr>
		<td>시험명</td>
		<td>${dto.sihumName }</td>
	</tr>
	<tr>
		<td>시험날짜</td>
		<td>${dto.sihumDate }</td>
	</tr>
	<tr>
		<td>등록일</td>
		<td>${dto.regiDate }</td>
	</tr>
</table>
</body>
</html>
<div style="border: 0px solid red; width:80%; margin-top: 10px;" align="right">
|
<a href="#" onClick="move('list.do','');">목록</a>
|
<a href="#" onClick="move('chuga.do','');">등록</a>
|
<a href="#" onClick="move('sujung.do','${dto.sihumNo }');">수정</a>
|
<a href="#" onClick="move('sakje.do','${dto.sihumNo }');">삭제</a>
|
</div>
<script>
	function move(value1, value2) {
		location.href = '${path }/haksaSihum_servlet/' + value1 + "?sihumNo=" + value2;
	}
</script>