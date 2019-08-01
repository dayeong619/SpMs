<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
	<jsp:include page="header.jsp"/>
	<form action="insert.do" method="post">
		<p>
			<label>프로젝트 이름</label>
			<input type="text" name="name">
		</p>
		<p>
			<label>프로젝트 내용</label>
			<textarea rows="10" cols="50" name="content"></textarea>
		</p>
		<p>
			<label>시작날짜</label>
			<input type="text" name="sDay">
		</p>
		<p>
			<label>마감날짜</label>
			<input type="text" name="eDay">
		</p>
		<p>
			<label>상태</label>
			<select name="select">
				<option>준비</option>
				<option>진행중</option>
				<option>종료</option>
				<option>보류</option>
			</select>
		</p>
		<p>
			<input type="submit" value="저장">
			<input type="reset" value="취소">
		</p>
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>