<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function move(s, t){	
	var source = document.getElementById(s);
	var target = document.getElementById(t);
	var addstr = source.selectedOptions;
	var delindex = source.selectedIndex;
	var opt1 = document.createElement("option");
	opt1.innerHTML = addstr[0].label;
	opt1.value = addstr[0].label;
	opt1.name = t + "[]"
	target.add(opt1);
	source.remove(delindex);
}
</script>
</head>
<body>
	<form action="./">
		<input type="submit" value="返回">
	</form>
	<form action="nurse_add" method="POST">
		<!-- <input type="hidden" name="assigned" value="assigned111"> -->
		<!--<input type="hidden" name="stationpool" value="stationpool111">-->
		<input type="submit" name="edit_button" value="<%=request.getAttribute("button_value")%>">
		<a>員工編號</a>
		<input type="text" name="nurse_id" readonly="" value="<%=request.getAttribute("nurse_id")%>"><br>
		<a>護士姓名</a><input type="text" name="name" value="<%=request.getAttribute("name")%>"><br>
		<a>分配站點</a>
		<div>
			<div style="float: left">
				<select id="idassigned" name="assigned" value="" multiple="" onclick=move('idassigned','idstationpool');>
					<%=request.getAttribute("assigned")%>
				</select>
			</div>
			<div style="float: left">
				←加入<br> 移除→
			</div>
			<div style="float: left">
				<select id="idstationpool" name="stationpool" value="" multiple="" onclick=move('idstationpool','idassigned');>
					<%=request.getAttribute("stationpool")%>
				</select>
			</div>
		</div>
	</form>
</body>
</html>