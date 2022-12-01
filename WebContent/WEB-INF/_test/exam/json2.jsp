<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>

<%@ include file = "../../_include/inc_menu.jsp" %>
<h2>json2</h2>

name - <input type="text" name="name" id="name"><br>
kor - <input type="text" name="kor" id="kor"><br>
eng - <input type="text" name="eng" id="eng"><br>
mat - <input type="text" name="mat" id="mat"><br>
sci - <input type="text" name="sci" id="sci"><br>
his - <input type="text" name="his" id="his"><br>
<button type="button" id="btnSave">확인</button>

<hr>

name - <span id="json_name"></span><br>
kor - <span id="json_kor"></span><br>
eng - <span id="json_eng"></span><br>
mat - <span id="json_mat"></span><br>
sci - <span id="json_sci"></span><br>
his - <span id="json_his"></span><br>
tot - <span id="json_tot"></span><br>
avg - <span id="json_avg"></span><br>


<hr>
<div id="result"></div>
</body>
</html>
<script>
	$(document).ready(function(){
		$("#btnSave").click(function(){
			examProc();
		});
	});
	function examProc() {
		var param = {
			name: $("#name").val(),
			kor: $("#kor").val(),
			eng: $("#eng").val(),
			mat: $("#mat").val(),
			sci: $("#sci").val(),
			his: $("#his").val(),
		}
		var url = "${path }/exam_servlet/join2Proc.do"
		$.ajax({
			type: "post",
			data: param,
			datatype: "JSON",
			url: url,
			success: function(data) { // 콜백함수 (서버에서 처리가 완료된 후 실행되는 코드)
				//$("#result").text(data);
				//console.log("data : " + data);
				//alert('1.' + data);
				var jsonMember = JSON.parse(data);
				//alert('2.' + jsonMember);
				$("#result").text(data);
				$("#json_name").text(jsonMember.name);
				$("#json_kor").text(jsonMember.kor);
				$("#json_eng").text(jsonMember.eng);
				$("#json_mat").text(jsonMember.mat);
				$("#json_sci").text(jsonMember.sci);
				$("#json_his").text(jsonMember.his);
				$("#json_tot").text(jsonMember.tot);
				$("#json_avg").text(jsonMember.avg);			
			}
		});
	}
</script>