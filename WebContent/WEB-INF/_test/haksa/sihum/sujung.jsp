<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    223796
    299192
    
    522988
    
    578421
    522988
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "../../../_include/inc_menu.jsp" %>
<h2>학사관리_시험수정</h2>
<form name="DirForm">
<input type="hidden" name="sihumNo" value="${dto.sihumNo }">
<table border="1">
	<tr>
		<td>시험명</td>
		<td><input type="text" name="sihumName" value="${dto.sihumName }"></td>
	</tr>
	<tr>
		<td>시험일</td>
		<td><input type="text" name="sihumDate" value="${dto.sihumDate }"></td>
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
			document.DirForm.action="${path }/haksaSihum_servlet/sujungProc.do"
			document.DirForm.method="post";
			document.DirForm.submit();
		}
	}
</script>
