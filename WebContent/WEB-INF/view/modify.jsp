<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	label{
		width: 200px;
		float: left;
		text-align: right;
		padding-right: 10px;
	}
	p:last-child {
		padding-left: 210px;
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js">
</script>
<script>
	$(function(){
		if("${project.progress}" == "준비"){
			$("#p").attr("selected", "selected");
		}else if("${project.progress}" == "진행중"){
			$("#pp").attr("selected", "selected");
		}else if("${project.progress}" == "종료"){
			$("#ppp").attr("selected", "selected");
		}else if("${project.progress}" == "보류"){
			$("#pppp").attr("selected", "selected");
		}
	})
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
	<form action="modify.do" method="post">
		<p>
			<label>프로젝트 이름</label>
			<input type="text" name="name" value="${project.name }">
			<input type="hidden" name="no" value="${project.no }">
		</p>
		<p>
			<label>프로젝트 내용</label>
			<textarea rows="10" cols="50" name="content">${project.content }</textarea>
		</p>
		<p>
			<label>시작날짜</label>
			<input type="text" name="sDay" value="${project.sday }">
		</p>
		<p>
			<label>마감날짜</label>
			<input type="text" name="eDay" value="${project.eday }">
		</p>
		<p>
			<label>상태</label>
			<select name="select">
				<option id="p">준비</option>
				<option id="pp">진행중</option>
				<option id="ppp">종료</option>
				<option id="pppp">보류</option>
			</select>
		</p>
		<p>
			<input type="submit" value="수정">
			<input type="reset" value="취소">
		</p>
	</form>
	<jsp:include page="footer.jsp"/>	
</body>
</html>