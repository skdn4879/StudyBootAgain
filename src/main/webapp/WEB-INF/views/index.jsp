<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<c:import url="./temp/boot.jsp"></c:import>
</head>
<body>
	<h1>Home</h1>
	<a href="/qna/list" class="btn btn-primary" role="button">게시글목록</a>
	
	<sec:authorize access="!isAuthenticated()">
		<a href="/member/login" class="btn btn-info" role="button">로그인</a>
		<a href="/member/join" class="btn btn-success" role="button">회원가입</a>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="name"/>
		<a href="/member/logout" class="btn btn-danger" role="button">로그아웃</a>
	</sec:authorize>
	
	
</body>
</html>