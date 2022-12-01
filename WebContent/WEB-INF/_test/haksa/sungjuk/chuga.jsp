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
<h2>학사관리_성적등록</h2>
<form name="DirForm">
<table border="1">
	<tr>
		<td>학번</td>
		<td>
<%-- 			<c:set var="k" value="${k = 0 }"/>
			<c:forEach var = "studentDto" items = "${studentList }">
				<c:if test = "${k == 0 }">
					<c:set var = "chkValue" value = "checked" />
				</c:if>
				<c:if test = "${k != 0 }">
					<c:set var = "chkValue" value = ""/>
				</c:if>

				<input type="radio" name="hakbun" value="${studentDto.hakbun }" checked>${k } / ${studentDto.hakbun } / ${studentDto.name }<br>
				<c:set var = "k" value = "${k = k + 1 }" />				
			</c:forEach> --%>
			<select name = "hakbun">
			<option value = "" selected>-- 선택 --</option>
			<c:forEach var = "studentDto" items = "${studentList }">
				<option value = "${studentDto.hakbun }">${studentDto.hakbun } / ${studentDto.name }</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>시험명</td>
		<td>
			<select name = "sihumNo">
			<option value = "" selected>-- 선택 --</option>
			<c:forEach var = "sihumDto" items = "${sihumList }">
				<option value = "${sihumDto.sihumNo }">${sihumDto.sihumNo } / ${sihumDto.sihumName }</option>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td>국어</td>
		<td><input type="text" name="kor"></td>
	</tr>
	<tr>
		<td>영어</td>
		<td><input type="text" name="eng"></td>
	</tr>
	<tr>
		<td>수학</td>
		<td><input type="text" name="mat"></td>
	</tr>
	<tr>
		<td>과학</td>
		<td><input type="text" name="sci"></td>
	</tr>
	<tr>
		<td>역사</td>
		<td><input type="text" name="his"></td>
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
		if(confirm('등록하시겠습니까?')) {
			document.DirForm.action="${path }/haksaSungjuk_servlet/chugaProc.do"
			document.DirForm.method="post";
			document.DirForm.submit();
		}
	}
</script>
