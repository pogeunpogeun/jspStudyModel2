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
<h2>학사관리_성적수정</h2>
<form name="DirForm">
<input type = "hidden" name = "sungjukNo" value = "${dto.sungjukNo }">
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
			<option value = "">-- 선택 --</option>
			<c:forEach var = "studentDto" items = "${studentList }">
				<c:set var = "selectedValue" value = ""/>
				<c:if test = "${studentDto.hakbun == dto.hakbun }">
				<c:set var = "selectedValue" value="selected" />
				</c:if>
				<option value = "${studentDto.hakbun }" ${selectedValue }>${studentDto.hakbun } / ${studentDto.name }</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>시험명</td>
		<td>
			<select name = "sihumNo">
			<option value = "">-- 선택 --</option>
			<c:forEach var = "sihumDto" items = "${sihumList }">
			<c:set var = "selectedValue" value = ""/>
			<c:if test="${sihumDto.sihumNo == dto.sihumNo }">
				<c:set var = "selectedValue" value="selected" />
				</c:if>
				<option value = "${sihumDto.sihumNo }" ${selectedValue }>${sihumDto.sihumNo } / ${sihumDto.sihumName }</option>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td>국어</td>
		<td><input type="text" name="kor" value = "${dto.kor }"></td>
	</tr>
	<tr>
		<td>영어</td>
		<td><input type="text" name="eng" value = "${dto.eng }"></td>
	</tr>
	<tr>
		<td>수학</td>
		<td><input type="text" name="mat" value = "${dto.mat }"></td>
	</tr>
	<tr>
		<td>과학</td>
		<td><input type="text" name="sci" value = "${dto.sci }"></td>
	</tr>
	<tr>
		<td>역사</td>
		<td><input type="text" name="his" value = "${dto.his }"></td>
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
		if(confirm('수정하시겠습니까?')) {
			document.DirForm.action="${path }/haksaSungjuk_servlet/sujungProc.do"
			document.DirForm.method="post";
			document.DirForm.submit();
		}
	}
</script>
