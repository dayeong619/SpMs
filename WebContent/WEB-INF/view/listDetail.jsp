<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	table, tr{
		border-collapse: collapse;
	}
	table{
		text-align:center;
		width: 750px;
	}
	#a{
		text-align: center;
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function(){
		$("#delete").click(function(){
			var a = confirm("삭제하시겠습니까?");
			if(a==true){
				location.href = "delete.do?no=${project.no }";
			}
				return false;
		})
	})
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div id="container">
	<table border="1">
		<tr>
			<th>프로젝트 이름</th>
			<td>${project.name }</td>
		</tr>
		<tr>
			<th>프로젝트 내용</th>
			<td>${project.content }</td>
		</tr>
		<tr>
			<th>시작날짜</th>
			<td>${project.sday }</td>
		</tr>
		<tr>
			<th>종료날짜</th>
			<td>${project.eday }</td>
		</tr>
		<tr>
			<th>상태</th>
			<td>${project.progress}</td>
		</tr>
	</table>
	<div id="a">
		<a href="modify.do?no=${project.no }">[수정]</a>
		<a href="#" id="delete">[삭제]</a>
		<a href="list.do">[돌아가기]</a>
	</div>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>




