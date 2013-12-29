<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<script type="text/javascript">
function load_func(){
	//親ウィンドウ(k) 
	var k=window.dialogArguments;
    if(k==null) { 
    	return;
    } 
    
    // 親ウィンドウの値を取得
    document.getElementById("mainIdInput").value = k.document.getElementById("currentMainIdInput").value; 
	
   
	
	return;
}
function update_ok(){
	window.returnValue = document.getElementById("mainIdInput").value;
	window.close();
}
function update_cancel(){
	window.close();
}
function select_main_id(thisObj){
	var objInput = document.getElementById("mainIdInput");
	var strInput = trimStr(objInput.value);
	if( strInput != ""){
		strInput += ", ";
	}
	strInput += thisObj.value;
	objInput.value = strInput;
}
// 前後の空白を除去
function trimStr(str){return str.replace(/(^\s*)|(\s*$)/g,"");}
</script>
<body onload="load_func()">
<form>
<textarea id="mainIdInput" name="mainIdInput" rows="3" cols="80"></textarea><br>
 <input type="button" onclick="update_cancel()" value="キャンセル">
 <input type="button" onclick="update_ok()" value="確定">
 <br/>
 <select multiple="multiple" size="20" onclick="select_main_id(this)">
 	<c:forEach items="${wk001List}" var="wk001Bean">
		<option value ="${wk001Bean.dispMainId}">
		  <c:out value="${wk001Bean.dispMainId}" />
		  <c:out value="${wk001Bean.name}" />
		  <fmt:formatDate value="${wk001Bean.receptionDay}" pattern="yyyy/MM/dd" />
		</option>
	</c:forEach>
</select>

</form>
</body>
</html>