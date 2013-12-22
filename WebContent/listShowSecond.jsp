<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>求人管理簿リスト一覧画面</title>
</head>
<script type="text/javascript">
function submit_listSecond_add(){
	document.getElementById("form1").action = "ListSecondPreAdd";
	document.getElementById("form1").submit();
} 

</script>
<body>
<h2>求人管理簿</h2>
<form id="form1" name="form1" method="post" action="">
  	<table border="1">
    	<tr>
      		<th>選択</th>
      		<th>求人事業所</th>
      		<th>受付年月日</th>
      		<th>求人数</th>
      		<th>職種</th>
      		<th>就労場所</th>
      		<th>雇用期間</th>
      		<th>賃金</th>
      		<th>処理状況</th>
      		<th>国内/海外</th>
      		<th>求人事業者からの求人票</th>
      		<th>自社の求人票</th>
      		<th>登録番号</th>
    	</tr>
    	<c:forEach items="${disp002List}" var="disp002Bean">
    		<c:set var="wk005Bean" value="${disp002Bean.wk005Bean}" />
    		<c:set var="wk006List" value="${disp002Bean.wk006List}" />
    		<%-- disp006Sizeの長さ，一行目の<td rowspan="？"> を決定する--%>
    		<c:set var="disp006Size" value="${fn:length(wk006List)}" />
    		<%-- disp006Sizeの長さ最低値は1。wk006Listの長さは0の場合、１に設定する --%>
    		<c:if test="${wk006List== null || fn:length(wk006List) == 0}">
    			<c:set var="disp006Size" value="1" />
    		</c:if>
    		
    		<%-- 最初のレコードは、すべて<TR>を表示する。（wk005Bean和wk006List最初のレコード。） --%>
    		  <tr>
			    <td rowspan="${disp006Size}"><input type="checkbox" id="" name="" value=""></td>
			   <%--  <td rowspan="${disp006Size}"><c:out value="${wk005Bean.tradeId}" /></td> --%>
			    <td rowspan="${disp006Size}"><c:out value="${wk005Bean.forBusiness}" /></td>
			    <td><fmt:formatDate value="${wk006List[0].receptionDay}" pattern="yyyy/MM/dd" /></td>
			    <td><c:out value="${wk006List[0].quantity}" /></td>
			    <td><c:out value="${wk006List[0].occupation}" /></td>
			    <td><c:out value="${wk006List[0].workLocation}" /></td>
			    <td><c:out value="${wk006List[0].period}" /></td>
			    <td><c:out value="${wk006List[0].wage}" /></td>
			    <td><c:out value="${wk006List[0].conditions}" /></td>
			    <td><c:out value="${wk006List[0].place}" /></td>
			    <td><c:out value="${wk006List[0].recruitmentFrom}" /></td>
			    <td><c:out value="${wk006List[0].recruitmentOwn}" /></td>
			    <td><c:out value="${wk006List[0].mainId}" /></td>
			  </tr>
    		<%-- ここでは第二のレコードが始まったwk006Listをループする --%>
    		<c:forEach items="${wk006List}" var="wk006Bean" begin= "1" end = "${disp006Size-1}">
    		  <tr>
			    <td><fmt:formatDate value="${wk006Bean.receptionDay}" pattern="yyyy/MM/dd" /></td>
    			<td><c:out value="${wk006Bean.quantity}" /></td>
			    <td><c:out value="${wk006Bean.occupation}" /></td>
			    <td><c:out value="${wk006Bean.workLocation}" /></td>
			    <td><c:out value="${wk006Bean.period}" /></td>
			    <td><c:out value="${wk006Bean.wage}" /></td>
			    <td><c:out value="${wk006Bean.conditions}" /></td>
			    <td><c:out value="${wk006Bean.place}" /></td>
			    <td><c:out value="${wk006Bean.recruitmentFrom}" /></td>
			    <td><c:out value="${wk006Bean.recruitmentOwn}" /></td>
			    <td><c:out value="${wk006Bean.mainId}" /></td>
			  </tr>
    		</c:forEach>
    	</c:forEach>
	</table><br />
<a href="#" onclick="submit_listSecond_add();return false;">新規</a>
<a href="#" onclick="submit_listSecond_edit();return false">編集</a>
</form>

</body>
</html>
    
 