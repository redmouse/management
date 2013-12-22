<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<script type="text/javascript">
function load_func(){
	//父窗口(k) 
	var k=window.dialogArguments;
    if(k==null) { 
    	return;
    } 
    
    // 获得父页面值
    document.getElementById("childText").value = k.document.getElementById("fatherText").value; 
	
    var option = k.document.getElementById("optionView").value;
    if(option == "display"){
    	document.getElementById("childText").readOnly = true;
    }
    else{
    	document.getElementById("childText").readOnly = false;
    }
	
	return;
}
function update_ok(){
	window.returnValue = document.getElementById("childText").value;
	window.close();
}
function update_cancel(){
	window.close();
}
</script>
<body onload="load_func()">
<form>
<textarea id="childText" name="childText" rows="30" cols="80"></textarea>
 <input type="button" onclick="update_cancel()" value="キャンセル">
 <input type="button" onclick="update_ok()" value="登録">
</form>
</body>
</html>