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
<h2>학사관리_학생삭제</h2>
<form name="DirForm">
<input type="hidden" name="hakbun" value="${dto.hakbun }">
<table border="1">
	<tr>
		<td>이름</td>
		<td>${dto.name }</td>
	</tr>
	<tr>
		<td>연락처</td>
		<td>${dto.phone }</td>
	</tr>
	<tr>
		<td>부모연락처</td>
		<td>${dto.parentPhone }</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>
			${dto.addr1 } ${dto.addr2 } ${dto.addr3 } ${dto.addr4 } 
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
			document.DirForm.action="${path }/haksaStudent_servlet/sakjeProc.do"
			document.DirForm.method="post";
			document.DirForm.submit();
		}
	}
</script>

</body>
</html>