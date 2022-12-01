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
<h2>직원관리_사원등록</h2>
<form name="DirForm">
<table border="1" width="50%">
	<tr>
		<td>이름</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>연락처</td>
		<td><input type="text" name="phone"></td>
	</tr>
	<tr>
		<td>입사일</td>
		<td><input type="date" name="hireDate"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>연봉</td>
		<td>
			<select name="salary">
			<option value="">--선택--</option>
				<option value="3000000">300
				<option value="4000000">400
				<option value="5000000">500
				<option value="6000000">600
			</select>
		</td>
	</tr>
	<tr>
		<td>부서</td>
		<td>
			<select name="buseoNo">
				<option value="" selected>--선택--</option>
				<c:forEach var = "chugaDto" items="${list }">
					<option value="${chugaDto.buseoNo }">${chugaDto.buseoNo } / ${chugaDto.buseoName }</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onClick="save();">등록하기</button>
</table>
</form>
</body>
</html>
<script>
	function save() {
		if(confirm('등록하시겠습니까?')) {
			document.DirForm.action="${path }/employee_servlet/chugaProc.do"
			document.DirForm.method="";
			document.DirForm.submit();
		}
	}
</script>