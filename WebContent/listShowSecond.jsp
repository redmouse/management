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
<style>
#menu {
margin-left:120px;
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
	padding-left:690px;
}


</style>
</head>
<script type="text/javascript">
function submit_list_back(){
	document.getElementById("form1").action = "select.jsp";
	document.getElementById("form1").submit();
}
function submit_for_work(mainId){
	document.getElementById("mainId").value = mainId;
	document.getElementById("form1").action = "ListPreModify";
	document.getElementById("form1").submit();
}
function submit_listSecond_add(){
	document.getElementById("form1").action = "ListSecondPreAdd";
	document.getElementById("form1").submit();
}
function submit_listSecond_edit(){
	// check:少なくとも1のラジオボタンを選択する必要があります
	if(!check_radio_selected()){
		alert('求人事業所を選択してください！');
		return;
	}

	document.getElementById("form1").action = "ListSecondPreModify";
	document.getElementById("form1").submit();
}
function submit_kyusyoku() {
	document.getElementById("form1").action = "ListShow";
	document.getElementById("form1").submit();
}
function submit_fee() {
	document.getElementById("form1").action = "ListShowFee";
	document.getElementById("form1").submit();
}
function submit_year_change(){
	document.getElementById("form1").action = "ListShowSecond";
	document.getElementById("form1").submit();
}
function check_radio_selected() {
	var v = document.getElementsByName('radioForBusiness');
	for ( var i = 0; i < v.length; i++) {
		if (v.item(i).checked) {
			return true;
		}
	}
	return false;
}
function popup_window(infoId, dbColumnName) {
	window.showModalDialog("Pop?popInfoId="+infoId+"&popColumn="+dbColumnName,window,"dialogHeight=600px;dialogWidth=700px;dialogLeft=0px;dialogTop=0px;center=yes;resizable=no;status=no;scroll=yes;help=no;");
	return false;
}


</script>
<body>
<h1 align=center>求人管理簿</h1>
<div id="menu">
<ul style="list-style-type: none">
<li><input type="button" onclick="submit_list_back()" value="戻る"></li>
<li><input type="button" onclick="submit_listSecond_add()" value="新規"></li>
<li><input type="button" onclick="submit_listSecond_edit()" value="編集"></li>
<li id="kyusyoku"><input type="button" onclick="submit_kyusyoku();" value="求職管理簿"></li>
<li><input type="button" onclick="submit_fee();" value="手数料管理簿"></li>
</ul>
</div>
<form id="form1" name="form1" method="post" action="">
	<!-- こちらのmaindIdは、求職管理簿へLinkのため -->
	<input type="hidden" id="mainId" name="mainId" value="">
	<!-- pop windowで、displayなら、textareaが変更できないように -->
	<input type="hidden" id="optionView" name="optionView" value="display">

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

  	<table  align="center" border="1">
    	<tr>
      		<th>選択</th>
      		<th>NO.</th>
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
      		<th>応募者名</th>
    	</tr>
    	<c:set var="descNo" value="${fn:length(disp002List)}" />
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
			    <td rowspan="${disp006Size}"><input type="radio" id="radioForBusiness" name="radioForBusiness" value="${wk005Bean.tradeId}"></td>
			   <%--  <td rowspan="${disp006Size}"><c:out value="${wk005Bean.tradeId}" /></td> --%>
			    <td rowspan="${disp006Size}"><c:out value="${descNo}" /></td>
			    <c:set var="descNo" value="${descNo-1}" />
			    <td rowspan="${disp006Size}"><c:out value="${wk005Bean.forBusiness}" /></td>
			    <c:set var="wk006Bean" value="${wk006List[0]}" />
			    <td><fmt:formatDate value="${wk006Bean.receptionDay}" pattern="yyyy/MM/dd" /></td>
			    <td><c:out value="${wk006Bean.quantity}" /></td>
			    <td><c:out value="${wk006Bean.occupation}" /></td>
			    <td><c:out value="${wk006Bean.workLocation}" /></td>
			    <td><c:out value="${wk006Bean.period}" /></td>
			    <td><c:out value="${wk006Bean.wage}" /></td>
			    <td><c:out value="${wk006Bean.conditions}" /></td>
			    <td><c:out value="${wk006Bean.place}" /></td>
			    <td align="center">
			    	<input type="button" value="求人票詳細" onclick="popup_window('${wk006Bean.infoId}','recruitmentFrom');return false;"/>
			    </td>
			    <td align="center">
			    	<input type="button" value="求人票詳細" onclick="popup_window('${wk006Bean.infoId}','recruitmentOwn');return false;"/>
			    </td>
			    <td>
			        <%-- mainIdのリンク処理 --%>
			    	<c:forEach items="${wk006Bean.dispMainIdList}" var="idPairBean">
			    	    <a href="#" style="text-decoration:none" onclick="submit_for_work('${idPairBean.mainId}');return false;">
			    			<c:out value="${idPairBean.name}" />
			    	    </a>
			    	</c:forEach>
                </td>
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
			    <td align="center">
			    	<input type="button" value="求人票詳細" onclick="popup_window('${wk006Bean.infoId}','recruitmentFrom');return false;"/>
			    </td>
			    <td align="center">
					<input type="button" value="求人票詳細" onclick="popup_window('${wk006Bean.infoId}','recruitmentOwn');return false;"/>
			    </td>
			    <td>
			        <%-- mainIdのリンク処理 --%>
			    	<c:forEach items="${wk006Bean.dispMainIdList}" var="idPairBean">
			    	    <a href="#" style="text-decoration:none" onclick="submit_for_work('${idPairBean.mainId}');return false;">
			    			<c:out value="${idPairBean.name}" />
			    	    </a>
			    	</c:forEach>
                </td>
			  </tr>
    		</c:forEach>
    	</c:forEach>
	</table><br />
<!-- <div align="right">
<a href="#" onclick="submit_listSecond_add();return false;">新規</a>
<a href="#" onclick="submit_listSecond_edit();return false">編集</a>
</div> -->
</form>


</body>
</html>

