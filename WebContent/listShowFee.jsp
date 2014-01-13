<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手数料管理簿</title>
<style>
#menu {
margin-left:45px;
margin-bottom:20px;
overflow:hidden;
}
ul>li{
	float:left;
}
#kyujinn{
padding-left:800px;
}

</style>
</head>
<script type="text/javascript">
function submit_list_back(){
	document.getElementById("form1").action = "select.jsp";
	document.getElementById("form1").submit();
} 
function submit_kyusyoku() {
	document.getElementById("form1").action = "ListShow";
	document.getElementById("form1").submit();
}
function submit_kyujinn() {
	document.getElementById("form1").action = "ListShowSecond";
	document.getElementById("form1").submit();
}
</script>
<body>
<h1 align=center>手数料管理簿</h1>
<div id="menu">
<ul style="list-style-type: none">
<li><input type="button" onclick="submit_list_back()" value="戻る"></li>
<li id="kyusyoku"><input type="button" onclick="submit_kyusyoku();" value="求職管理簿"></li>
<li id="kyujinn"><input type="button" onclick="submit_kyujinn();" value="求人管理簿"></li>
</ul>
</div>
<form id="form1" name="form1" method="post" action="">
	<input type="hidden" id="mainId" name="mainId" >
  	<table border="1" align=center>
    	<tr>
      		<th>氏名</th>
      		<th>就職年月日</th>
      		<th>離職日</th>
      		<th>手数料（消費税込み）</th>
      		<th>登録番号</th>
    	</tr>
    	<c:forEach items="${disp001List}" var="disp001Bean">
    		  <tr>
			    <td><c:out value="${wk001Bean.name}" /></td>
			    <td><fmt:formatDate value="${wk001Bean.inaugurationDay}" pattern="yyyy/MM/dd" /></td>
			    <td><fmt:formatDate value="${wk001Bean.turnoverDay}" pattern="yyyy/MM/dd" /></td>
			    <td><c:out value="${wk001Bean.fee}" /></td>
			    <td><a href="#" onclick="submit_list_modify(${wk001Bean.mainId});return false;">
			    <c:out value="${wk001Bean.dispMainId}" /></a></td>
			  </tr>
    	</c:forEach>
	</table><br />
 
</form>

</body>
</html>
    
 