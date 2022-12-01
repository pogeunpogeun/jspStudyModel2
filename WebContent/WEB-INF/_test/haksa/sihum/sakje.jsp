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
<h2>학사관리_시험삭제</h2>
<form name="DirForm">
<input type="hidden" name="sihumNo" value="${dto.sihumNo }">
<table border="1">
	<tr>
		<td>시험번호</td>
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
		<td>
			${dto.regiDate }
		</td>
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
			document.DirForm.action="${path }/haksaSihum_servlet/sakjeProc.do"
			document.DirForm.method="post";
			document.DirForm.submit();
		}
	}
</script>

</body>
</html>