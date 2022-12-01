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
<h2>학사관리_학생상세보기</h2>
<table border="1" width="80%">
	<tr>
		<td width="100px">학번</td>
		<td>${dto.hakbun }</td>
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
		<td>부모연락처</td>
		<td>${dto.parentPhone }</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>${dto.addr1 } ${dto.addr2 } ${dto.addr3 } ${dto.addr4 }</td>
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
<a href="#" onClick="move('sujung.do','${dto.hakbun }');">수정</a>
|
<a href="#" onClick="move('sakje.do','${dto.hakbun }');">삭제</a>
|
</div>
<script>
	function move(value1, value2) {
		location.href = '${path }/haksaStudent_servlet/' + value1 + "?hakbun=" + value2;
	}
</script>