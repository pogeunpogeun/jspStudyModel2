<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../_include/inc_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "../../_include/inc_menu.jsp" %>
	<h2>06Result1</h2>
<table border="1">
	<tr>
		<td>아이디</td>
		<td>${id }</td>
	</tr>
	<tr>
		<td>성공여부</td>
		<td>${result }</td>
	</tr>
</table>

<%-- 
<a href="/jspStudyModel2/exam_servlet/06Proc2.do?id=" + ${id } + "&result=" + ${result }">다음페이지로</a>
--%>

<%--
<form name="DirForm">
<input type="text" name="id" value="${id }">
<input type="text" name="result" value="${result }">
</form>
<script>
	function autoMove() {
		document.DirForm.action="/jspStudyModel2/exam_servlet/06Proc2.do";
		document.DirForm.method="post";
		document.DirForm.submit();
	}
	autoMove();
</script>
--%>
<meta http-equiv="refresh" content ="0; url=/jspStudyModel2/exam_servlet/06Proc2.do?id=${id }&result=${result}">
 