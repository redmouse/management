<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>求職管理簿リスト一覧画面</title>
<style>
#menu {
margin-left:70px;
margin-bottom:20px;
overflow:hidden;
}
ul>li{
	float:left;
}
li{
margin-right:2px;
}
#kyujinn{
padding-left:737px;
}

</style>
</head>
<script type="text/javascript">
function submit_list_modify(mainId){
	document.getElementById("mainId").value = mainId;
	document.getElementById("form1").action = "ListPreModify";
	document.getElementById("form1").submit();
}
function submit_list_delete(){
	document.getElementById("form1").action = "ListDelete";
	if(!confirm("削除してよろしいですか？")){
		return;
	}
	document.getElementById("form1").submit();
}
function submit_list_back(){
	document.getElementById("form1").action = "select.jsp";
	document.getElementById("form1").submit();
} 
function submit_list_add(){
	document.getElementById("form1").action = "ListPreAdd";
	document.getElementById("form1").submit();
} 
function submit_search(){
	document.getElementById("form1").action = "SearchPre";
	document.getElementById("form1").submit();
} 
function submit_listSecond_show(){
	document.getElementById("form1").action = "ListShowSecond";
	document.getElementById("form1").submit();
}
function submit_kyujinn() {
	document.getElementById("form1").action = "ListShowSecond";
	document.getElementById("form1").submit();
}
function submit_fee() {
	document.getElementById("form1").action = "ListShowFee";
	document.getElementById("form1").submit();
}
</script>
<body>
<h1 align=center>求職管理簿</h1>
<div id="menu">
<ul style="list-style-type: none">
<li><input type="button" onclick="submit_list_back()" value="戻る"></li>
<li><input type="button" onclick="submit_list_add()" value="新規"></li>
<li><input type="button" onclick="submit_search()" value="検索"></li>
<li><input type="button" onclick="submit_list_delete()" value="削除"></li> 
<li id="kyujinn"><input type="button" onclick="submit_kyujinn();" value="求人管理簿"></li>
<li id="kee"><input type="button" onclick="submit_fee();" value="手数料管理簿"></li>
</ul>
</div>
<form id="form1" name="form1" method="post" action="">
	<input type="hidden" id="mainId" name="mainId" >
  	<table border="1" align=center>
    	<tr>
      		<th>選択</th>
      		<th>受付年月日</th>
      		<th>氏名</th>
      		<th>生年月日</th>
      		<th>住所</th>
      		<th>希望職種</th>
      		<th>求人事業者</th>
      		<th>紹介年月日</th>
      		<th>面接日時</th>
      		<th>就職年月日</th>
      		<th>離職日</th>
      		<th>手数料（税込み）</th>
      		<th>国内/海外</th>
      		<th>登録番号</th>
    	</tr>
    	<c:forEach items="${disp001List}" var="disp001Bean">
    		<c:set var="wk001Bean" value="${disp001Bean.wk001Bean}" />
    		<c:set var="wk004List" value="${disp001Bean.wk004List}" />
    		<%-- disp004Sizeの長さ，一行目的<td rowspan="？"> を決定する--%>
    		<c:set var="disp004Size" value="${fn:length(wk004List)}" />
    		<%-- disp004Sizeの長さ最低値は1。wk004Listの長さは0の場合、１に設定する --%>
    		<c:if test="${wk004List== null || fn:length(wk004List) == 0}">
    			<c:set var="disp004Size" value="1" />
    		</c:if>
    		<%-- 最初のレコードは、すべて<TR>を表示する。（wk001Bean和wk004List最初のレコード。） --%>
    		  <tr>
			    <td rowspan="${disp004Size}"><input type="checkbox" id="del" name="del" value="${wk001Bean.mainId}"></td>
			    <td rowspan="${disp004Size}"><fmt:formatDate value="${wk001Bean.receptionDay}" pattern="yyyy/MM/dd" /></td>
			    <td rowspan="${disp004Size}"><c:out value="${wk001Bean.name}" /></td>
			    <td rowspan="${disp004Size}"><fmt:formatDate value="${wk001Bean.birthDay}" pattern="yyyy/MM/dd" /></td>
			    <td rowspan="${disp004Size}"><c:out value="${wk001Bean.address}" /></td>
			    <td><c:out value="${wk004List[0].hopePosition}" /></td>
			    <td><c:out value="${wk004List[0].forBusiness}" /></td>
			    <td><fmt:formatDate value="${wk004List[0].introductionDay}" pattern="yyyy/MM/dd" /></td>
			    <td><fmt:formatDate value="${wk004List[0].interviewDay}" pattern="yyyy/MM/dd" /></td>
			    <td><fmt:formatDate value="${wk004List[0].inaugurationDay}" pattern="yyyy/MM/dd" /></td>
			    <td><fmt:formatDate value="${wk004List[0].turnoverDay}" pattern="yyyy/MM/dd" /></td>
			    <td><c:out value="${wk004List[0].dispFee}" /></td>
			    <td rowspan="${disp004Size}"><c:out value="${wk001Bean.dispPlace}" /></td>
			    <td rowspan="${disp004Size}"><a href="#" onclick="submit_list_modify(${wk001Bean.mainId});return false;">
			    <c:out value="${wk001Bean.dispMainId}" /></a></td>
			  </tr>
    		<%-- ここでは第二のレコードが始まったwk004Listをループする --%>
    		<c:forEach items="${wk004List}" var="wk004Bean" begin= "1" end = "${disp004Size-1}">
    		  <tr>
    			<td><c:out value="${wk004Bean.hopePosition}" /></td>
			    <td><c:out value="${wk004Bean.forBusiness}" /></td>
			    <td><fmt:formatDate value="${wk004Bean.introductionDay}" pattern="yyyy/MM/dd" /></td>
			    <td><fmt:formatDate value="${wk004Bean.interviewDay}" pattern="yyyy/MM/dd" /></td>
			    <td><fmt:formatDate value="${wk004Bean.inaugurationDay}" pattern="yyyy/MM/dd" /></td>
			    <td><fmt:formatDate value="${wk004Bean.turnoverDay}" pattern="yyyy/MM/dd" /></td>
			    <td><c:out value="${wk004Bean.dispFee}" /></td>
			  </tr>
    		</c:forEach>
    	</c:forEach>
	</table><br />
<!-- <a href="#" onclick="submit_list_add();return false;">新規</a>
<a href="#" onclick="submit_search();return false;">検索</a>
<a href="#" onclick="submit_listSecond_show();return false;">求人管理簿へ</a>
<a href="#" onclick="submit_list_delete();return false;">削除</a>
 -->
</form>

</body>
</html>
    
 