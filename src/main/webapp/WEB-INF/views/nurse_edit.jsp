<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<input type="submit" value="返回">
	<input type="submit" value="新增"><br>
	<a>員工編號</a><input type="text" name="nurse_id"><br>
	<a>護士姓名</a><input type="text" name="name"><br>
	<a>分配站點</a>
	<div>
		<div style="float">
			<select name="assign" multiple="">
				<option value="Taipei">台北</option>
				<option value="Taoyuan">桃園</option>
				<option value="Hsinchu">新竹</option>
				<option value="Miaoli">苗栗</option>
			</select>
		</div>
		<div style="float">
			<input type="submit" value="<-加入"><br> <input
				type="submit" value="移除->">
		</div>
		<div style="float">
			<select name="assign" multiple="">
				<option value="Taipei">台北</option>
				<option value="Taoyuan">桃園</option>
				<option value="Hsinchu">新竹</option>
				<option value="Miaoli">苗栗</option>
			</select>
		</div>
	</div>
</body>
</html>