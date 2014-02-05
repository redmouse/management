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
	margin-left:390px;
	margin-bottom:20px;
	overflow:hidden;
}
ul>li{
	float:left;
}
li{
	margin-right:2px;
}
#kyusyoku{
	padding-left:260px;
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
function submit_list_modify(mainId){
	document.getElementById("mainId").value = mainId;
	document.getElementById("form1").action = "ListPreModify";
	document.getElementById("form1").submit();
}
function submit_year_change(){
	document.getElementById("form1").action = "ListShowFee";
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
	<table border="0" align="center">
    	<tr>
      		<th>会計年度：　</th>
      		<td>
				<select id="yearBackCount" name="yearBackCount" onChange="submit_year_change();">
					<option value="0" <c:if test="${yearBackCount == 0 }"> selected </c:if>>当年度</option>
					<option value="1" <c:if test="${yearBackCount == 1 }"> selected </c:if>>1年前</option>
					<option value="2" <c:if test="${yearBackCount == 2 }"> selected </c:if>>2年前</option>
					<option value="3" <c:if test="${yearBackCount == 3 }"> selected </c:if>>3年前</option>
					<option value="4" <c:if test="${yearBackCount == 4 }"> selected </c:if>>4年前</option>
					<option value="5" <c:if test="${yearBackCount == 5 }"> selected </c:if>>5年前</option>
				</select>
			</td>
      		<td><c:out value="${startDay}" /> ～ <c:out value="${endDay}" /><br/></td>
    	</tr>
	</table><br />
  	<table border="1" align=center>
    	<tr>
      		<th>氏名</th>
      		<th>入社会社名</th>
      		<th>入社年月日</th>
      		<th>離職日</th>
      		<th>手数料（税込み）</th>
      		<th>登録番号</th>
    	</tr>
    	<c:forEach items="${disp003List}" var="disp003Bean">
    		  <tr>
			    <td><c:out value="${disp003Bean.wk001Bean.name}" /></td>
			    <td><c:out value="${disp003Bean.wk004Bean.forBusiness}" /></td>
			    <td><fmt:formatDate value="${disp003Bean.wk004Bean.inaugurationDay}" pattern="yyyy/MM/dd" /></td>
			    <td><fmt:formatDate value="${disp003Bean.wk004Bean.turnoverDay}" pattern="yyyy/MM/dd" /></td>
			    <td><fmt:formatNumber value="${disp003Bean.wk004Bean.dispFee}" type="CURRENCY" groupingUsed="true" /></td>
			    <td><a href="#" onclick="submit_list_modify(${disp003Bean.wk001Bean.mainId});return false;">
			    <c:out value="${disp003Bean.wk001Bean.dispMainId}" /></a></td>
			  </tr>
    	</c:forEach>
	</table><br />
	<table border="1" align="center">
    	<tr>
      		<th>合計金額：　</th>
      		<td border="1"><fmt:formatNumber value="${total}" type="CURRENCY" groupingUsed="true" /> 円</td>
    	</tr>
	</table><br />
 	　
 	
</form>

</body>
</html>
    
 