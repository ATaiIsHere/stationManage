<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./">
		<input type="submit" value="返回">
	</form>

	<table>
		<tr>
			<th><%=request.getAttribute("listype_id")%></th>
			<th>名稱</th>
			<th>修改時間</th>
			<th>動作</th>
			<%=request.getAttribute("showlist")%>
		</tr>
	</table>
</body>
</html>