<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	
	<form method="post" action="point_result_1.do">
		이름 :	<input type="text" name="name"> <br>
		국어 :	<input type="text" name="kor"> <br>
		영어 :	<input type="text" name="eng"> <br>
		수학 :	<input type="text" name="mat"> <br>
		<input type="submit" value="확인">
	</form>
</body>
</html>