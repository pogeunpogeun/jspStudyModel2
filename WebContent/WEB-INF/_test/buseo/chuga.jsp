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
<h2>부서관리_부서추가</h2>
<form name="DirForm">
	<table border="1" width="30%">
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2">
			<button type="button" onClick="save();">등록하기</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
<script>
	function save() {
		if(confirm('등록하시겠습니까?')) {
			document.DirForm.action="${path }/buseo_servlet/chugaProc.do"
			document.DirForm.method="post";
			document.DirForm.submit();
		}
	}
</script>