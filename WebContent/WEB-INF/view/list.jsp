<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container{
		margin-left: 30px;
		margin-top:10px;
		margin-bottom:10px;
	}
	#right{
		text-align: right;
	}
	table, tr{
		border-collapse: collapse;
	}
	table{
		text-align:center;
		width: 750px;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div id="container">
		<div id="right">
			<a href="insert.do">[새 프로젝트 등록]</a>
		</div>
		<table border="1">
			<tr>
				<th>프로젝트 이름</th>
				<th>시작날짜</th>
				<th>종료날짜</th>
				<th>상태</th>
			</tr>
			<c:forEach items="${list }" var="e">
				<tr>
					<td>
						<a href="listdetail.do?no=${e.no }">${e.name }</a>
					</td>
					<td>${e.sday }</td>
					<td>${e.eday }</td>
					<td>${e.progress }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>









