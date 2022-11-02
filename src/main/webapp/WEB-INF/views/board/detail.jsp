<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>

	<section class="container">
		<h1>Detail Page</h1>
		
		<table class="table table-info">
			<thead>
				<tr>
			      <th scope="col">Num</th>
			      <th scope="col">Writer</th>
			      <th scope="col">Title</th>
			      <th scope="col">Hit</th>
			      <th scope="col">RegDate</th>
			      <th scope="col">Ref</th>
			      <th scope="col">Step</th>
			      <th scope="col">Depth</th>
			    </tr>
			</thead>
			<tbody>
				<tr>
					<td>${qnaVO.num }</td>
					<td>${qnaVO.writer }</td>
					<td>${qnaVO.title }</td>
					<td>${qnaVO.hit }</td>
					<td>${qnaVO.regDate }</td>
					<td>${qnaVO.ref }</td>
					<td>${qnaVO.step }</td>
					<td>${qnaVO.depth }</td>
				</tr>
			</tbody>
		</table>
		
		<div class="mt-3 p-3 bg-light">
			<h3>${qnaVO.contents }</h3>
		</div>
		
		<c:if test="${qnaVO.qnaFiles.size() > 0 }">
			<c:forEach items="${qnaVO.qnaFiles }" var="qnaFile">
				<div class="d-inline-block m-3">
					<img alt="" src="/file/${fileCategory }/${qnaFile.fileName}" style="width: 15rem; height: 15rem; object-fit: contain;">
					<a href="/resources/down/${fileCategory }?fileNum=${qnaFile.fileNum}" class="btn btn-success" role="button">파일 다운</a>
				</div>
			</c:forEach>
		</c:if>
		
	</section>

</body>
</html>