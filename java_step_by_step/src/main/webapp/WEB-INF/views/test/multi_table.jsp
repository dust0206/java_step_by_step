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
	<h2>구구단 계산</h2>
	<form action="table_result.do" method="post">
		단: <input type="number" name="num" value="3">
		<input type="submit" value="확인">
	</form>
</body>
</html>