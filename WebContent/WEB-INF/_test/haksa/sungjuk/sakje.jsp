<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../../_include/inc_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "../../../_include/inc_menu.jsp" %>
<h2>학사관리_성적삭제</h2>
<form name="DirForm">
<input type = "hidden" name = "sungjukNo" value = "${dto.sungjukNo }">
<table border="1" width="80%">
	<tr>
		<td>성적번호</td>
		<td>${dto.sungjukNo }</td>
	</tr>
	<tr>
		<td>학번</td>
		<td>${dto.hakbun }</td>
	</tr>
	<tr>
		<td>시험번호</td>
		<td>${dto.sihumNo }</td>
	</tr>
	<tr>
		<td>시험이름</td>
		<td>${dto.sihumName }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${dto.studentName }</td>
	</tr>
	<tr>
		<td>국어</td>
		<td>${dto.kor }</td>
	</tr>
	<tr>
		<td>영어</td>
		<td>${dto.eng }</td>
	</tr>
	<tr>
		<td>수학</td>
		<td>${dto.mat }</td>
	</tr>
	<tr>
		<td>과학</td>
		<td>${dto.sci }</td>
	</tr>
	<tr>
		<td>역사</td>
		<td>${dto.his }</td>
	</tr>
	<tr>
		<td>총점</td>
		<td>${dto.tot }</td>
	</tr>
	<tr>
		<td>평균</td>
		<td>${dto.avg }</td>
	</tr>
	<tr>
		<td>등급</td>
		<td>${dto.grade }</td>
	</tr>
	<tr>
		<td>등록일</td>
		<td>${dto.regiDate }</td>
	</tr>
	<tr>
		<td colspan="2">
		<button type="button" onClick="save();">확인</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>
<script>
	function save() {
		if(confirm('삭제하시겠습니까?')) {
			document.DirForm.action="${path }/haksaSungjuk_servlet/sakjeProc.do"
			document.DirForm.method="post";
			document.DirForm.submit();
		}
	}
</script>