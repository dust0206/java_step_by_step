<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function() {
		#("#btn_login").click(function() {
			id = $("#id").val();	// 태그에 입력한 id
			pw = $("pw").val();		// 태그에 입력한 pw
			param = {"id":id, "pw":pw};		// 입력한 값을 파라미터로 만듬
			$.ajax({
				type: "post",
				url : "login_result.do",
				data : param,
				success: function(result) {		// login_result.jsp에 출력된 내용
					$("#result").html(result);
				}
			});
		});
	});
</script>	
	</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	
	<form action="login_result.do" method="post">
		아이디 : <input type="text" name="id" id="id">
		패스워드 : <input type="text" name="pw" id="pw">
		<input type="submit" value="전송" id="btn_login">
	</form>
	<div id="result"></div>
</body>
</html>