<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
	<form action="./">
		<input type="submit" value="返回">
	</form>
	<form action="station_add" method="POST">
		<input type="submit" name="edit_button" value="<%=request.getAttribute("button_value")%>">
		<input type="hidden" name="station_id" value="">
		<br>
		<a>站點名稱</a><input type="text" name="name" value="<%=request.getAttribute("name")%>">
	</form>
	<br>
	<%=request.getAttribute("showlist") %>
</body>
</html>