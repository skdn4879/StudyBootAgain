<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>List Page</h1>
	
	<section class="container-fluid col-10 mt-4 mb-4">
		<div>
			<select name="kind" id="kind">
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="contents">내용</option>
			</select>
			<input type="text" name="search" id="search">
			<button type="button" class="btn btn-success" id="searchBtn">검색</button>
		</div>
		
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
				<c:forEach items="${qnaList }" var="qnaVO">
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
				</c:forEach>
			</tbody>
		</table>
		
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  	<c:if test="${pager.pre }">
		  		<li class="page-item">
			      <a class="page-link" href="/qna/list?page=${pager.startNum - 1 }&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
		  	</c:if>
		    <c:forEach begin="${pager.startNum }" end="${pager.lastNum }" step="1" var="i">
		    	<li class="page-item"><a class="page-link" href="/qna/list?page=${i }&kind=${pager.kind}&search=${pager.search}">${i }</a></li>
		    </c:forEach>
		    <c:if test="${pager.next }">
		    	<li class="page-item">
			      <a class="page-link" href="/qna/list?page=${pager.lastNum + 1 }&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
		    </c:if>
		  </ul>
		</nav>
		
		<a href="./add" class="btn btn-primary" role="button">글쓰기</a>
	</section>
	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script type="text/javascript" src="/js/qnaList.js"></script>
</body>
</html>