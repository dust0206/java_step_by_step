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
	
	이름 : ${dto.getName() }<br/>
	국어 : ${dto.getKor() }<br/>
	영어 : ${dto.getEng() }<br/>
	수학 : ${dto.getMat() }<br/>
	총점 : ${dto.getTotal() }<br/>
	평균 : ${dto.average }<br/>
</body>
</html>