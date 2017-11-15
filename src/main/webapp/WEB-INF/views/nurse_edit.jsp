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

function addHidden(theSpan, key, value) {
    var input = document.createElement('input');
    input.type = 'hidden';
    input.name = key; // 'the key/name of the attribute/field that is sent to the server
    input.value = value;
    theSpan.appendChild(input);
}

function edit(){
	var form1 = document.getElementById("hiddenform");
	var formdata = document.getElementById("formdata");
	var assignedop = document.getElementById("assigned").options;
	var stationpoolop = document.getElementById("stationpool").options;
	addHidden(formdata, "nurse_id", document.getElementById("nurse_id").value);
	addHidden(formdata, "name", document.getElementById("name").value);
	addHidden(formdata, "edit_button", document.getElementById("edit_button").value);
	addHidden(formdata, "assigned[]", "");
	addHidden(formdata, "stationpool[]", "");
	for(var i=0; i<assignedop.length; i++){
		addHidden(formdata, "assigned[]", assignedop[i].label);
	}
	for(var i=0; i<stationpoolop.length; i++){
		addHidden(formdata, "stationpool[]", stationpoolop[i].label);
	}
	form1.submit()
}
</script>
</head>
<body>
	<form action="./">
		<input type="submit" value="返回">
	</form>
	<!-- <input type="hidden" name="assigned" value="assigned111"> -->
	<!--<input type="hidden" name="stationpool" value="stationpool111">-->
	<input type="submit" id="edit_button" value="<%=request.getAttribute("button_value")%>" onclick=edit()>
	<a>員工編號</a>
	<input type="text" id="nurse_id" readonly="" value="<%=request.getAttribute("nurse_id")%>"><br>
	<a>護士姓名</a><input type="text" id="name" value="<%=request.getAttribute("name")%>"><br>
	<a>分配站點</a>
	<div>
		<div style="float: left">
			<select id="assigned" multiple="" onclick=move('assigned','stationpool');>
				<%=request.getAttribute("assigned")%>
			</select>
		</div>
		<div style="float: left">
			←加入<br> 移除→
		</div>
		<div style="float: left">
			<select id="stationpool" multiple="" onclick=move('stationpool','assigned');>
				<%=request.getAttribute("stationpool")%>
			</select>
		</div>
	</div>
	<form id="hiddenform" action="nurse_add" method="GET"><span id="formdata"></span></form>
</body>
</html>