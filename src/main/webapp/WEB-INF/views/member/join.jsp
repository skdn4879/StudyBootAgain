<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>회원가입 페이지</h1>
	
	<form:form	modelAttribute="memberVO" method="post">
		<div class="input-group mb-3">
		  <span class="input-group-text" id="idText">ID</span>
		  <form:input path="id" cssClass="form-control" id="id"/>
		</div>
		<form:errors path="id"></form:errors>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="pwText">PW</span>
		  <form:password path="pw" cssClass="form-control" id="pw"/>
		</div>
		<form:errors path="pw"></form:errors>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="pwCheckText">PWCHECK</span>
		  <form:password path="pwcheck" cssClass="form-control" id="pwcheck"/>
		</div>
		<form:errors path="pwcheck"></form:errors>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="nameText">Name</span>
		  <form:input path="name" cssClass="form-control" id="name"/>
		</div>
		<form:errors path="name"></form:errors>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="emailText">Email</span>
		  <form:input path="email" cssClass="form-control" id="email"/>
		</div>
		<form:errors path="email"></form:errors>
		<button type="submit" class="btn btn-success">가입</button>
	</form:form>
	
</body>
</html>