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
<h2>직원관리_사원삭제</h2>
<form name="DirForm">
<input type="hidden" name="sabun" value="${dto.sabun }">
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
			<td>${dto.buseo }</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${dto.regiDate }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onClick="save();">삭제하기</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
<script>
	function save() {
		if(confirm('삭제하시겠습니까?')) {
			document.DirForm.action="${path }/employee_servlet/sakjeProc.do"
			document.DirForm.method="";
			document.DirForm.submit();
		}
	}
</script>