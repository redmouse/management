<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>popup window</title>
</head>
<script type="text/javascript">
function load_func(){
	//親ウィンドウ(k) 
	var k=window.dialogArguments;
    if(k==null) { 
    	return;
    } 
    
    // 親ウィンドウの値を取得
    document.getElementById("childText").value = k.document.getElementById("fatherText").value;
    document.getElementById("label_title").innerHTML = k.document.getElementById("popTitle").value; 
	
    var option = k.document.getElementById("optionView").value;
    if(option=="display"){
    	document.getElementById("childText").readOnly = true;
    	document.getElementById("btn_cancel").style.display="none";
    	document.getElementById("btn_ok").style.display="none";
    }
    else{
    	document.getElementById("childText").readOnly = false;
    	document.getElementById("btn_close").style.display="none";
    }
	
	return;
}
function update_ok(){
	window.returnValue = document.getElementById("childText").value;
	window.close();
}
</script>
<body onload="load_func()">
<form>
<label id="label_title"></label>
<textarea id="childText" name="childText" rows="30" cols="80"></textarea><br>
 <input id="btn_cancel" type="button" onclick="window.close();" value="キャンセル">
 <input id="btn_ok" type="button" onclick="update_ok()" value="確定">
 <input id="btn_close" type="button" onclick="window.close();" value="閉じる">
</form>
</body>
</html>