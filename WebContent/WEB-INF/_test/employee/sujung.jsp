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
<h2>직원관리_사원수정</h2>
<form name="DirForm">
<input type="text" name="sabun" value="${dto.sabun }">
<table border="1" width="50%">
	<tr>
		<td>이름</td>
		<td>${dto.name }</td>
	</tr>
	<tr>
		<td>연락처</td>
		<td><input type="text" name="phone" value="${dto.phone }"></td>
	</tr>
	<tr>
		<td>입사일</td>
		<td><input type="date" name="hireDate" value="${dto.hireDate }"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email" value="${dto.email }"></td>
	</tr>
	<tr>
		<td>연봉</td>
		<td>
			<input type="text" name="salary">
		</td>
	</tr>
	<tr>
		<td>부서</td>
		<td>
			<select name="buseo">
				<option value="">--선택--</option>
				<option value="인사">인사부</option>
				<option value="회계">회계부</option>
				<option value="영업">영업부</option>
				<option value="기획">기획부</option>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onClick="save();">수정하기</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>
<script>
	function save() {
		if(confirm('수정하시겠습니까?')) {
			document.DirForm.action="${path }/employee_servlet/sujungProc.do"
			document.DirForm.method="";
			document.DirForm.submit();
		}
	}
</script>