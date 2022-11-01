<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
<link href="/css/qnaAdd.css" rel="stylesheet">
</head>
<body>
	
	<section class="container w-50 p-3">
		<h1>Write Qna</h1>
		
		<form:form method="post" modelAttribute="qnaVO" enctype="multipart/form-data" id="addForm">
			<div class="input-group mb-3 mt-3">
			  <span class="input-group-text" id="writerText">작성자</span>
			  <form:input path="writer" cssClass="form-control" placeholder="작성자" aria-label="writer" aria-describedby="writer" id="writer"/>
			</div>
			<div class="errorMsgFrame" id="writerErrorMessage">
			  <form:errors path="writer"></form:errors>
			</div>
			<div class="input-group mb-3 mt-3">
			  <span class="input-group-text" id="titleText">제목</span>
			  <form:input path="title" cssClass="form-control" placeholder="제목" aria-label="Title" aria-describedby="Title" id="title"/>
			</div>
			<div class="errorMsgFrame" id="titleErrorMessage">
			  <form:errors path="title"></form:errors>
			</div>
			<div class="input-group mb-3 mt-3">
			  <span class="input-group-text" id="contentsText">내용</span>
			  <form:textarea path="contents" id="contents"/>
			</div>
			<div class="errorMsgFrame" id="contentsErrorMessage">
			  <form:errors path="contents"></form:errors>
			</div>
			
			<div class="mb-3" id="fileList">
				
			</div>
		
			<button type="button" class="btn btn-primary mt-3" id="fileAddBtn">파일추가</button>
		
			<button type="button" class="btn btn-info mt-3" id="addBtn">글쓰기</button>
			
		</form:form>
		
	</section>
	
	
	<script type="text/javascript" src="/js/qnaAdd.js"></script>
	<script type="text/template" id="fileFormTemp">
		<div class="input-group mb-3">
			<label for="files" class="form-label" style="font-size: 1.3rem; font-weight: bold;">File</label>
			<input type="file" class="form-control" name="files">
			<button type="button" class="btn btn-danger fileDeleteBtn">파일삭제</button>
		</div>
	</script>
</body>
</html>