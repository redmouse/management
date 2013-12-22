<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>検索画面</title>
</head>

<script type="text/javascript">
function submit_list_show() {
	document.getElementById("form1").action = "ListShow";
	document.getElementById("form1").submit();
}
function submit_list_modify(mainId){
	document.getElementById("mainId").value = mainId;
	document.getElementById("form1").action = "ListPreModify";
	document.getElementById("form1").submit();
}
//---------- Jquery  -----------
$(document).ready(function(){
	$("#level1Id").change(function(){
		$("#level2Area").load("Linkage",{level1Id:$("#level1Id  option:selected").val()});
		});
	
});
function level2_changed(){
	$("#level3Area").load("Linkage",{level2Id:$("#level2Id  option:selected").val()});
}
</script>

<body>
<form id="form1" name="form1" action="Search" method="post">
	<input type="hidden" id="mainId" name="mainId" >
	<input type="button" value="戻る" onclick="submit_list_show();">
	<h1>検索画面</h1>
	<h2>検索条件を入れてください!</h2>
	<p>英語レベル：
	        <input type="radio" name="englishLevel" id="englishLevel" value="0" 
	         <c:if test="${searchBean.wk001Bean.englishLevel == 0}"> checked </c:if>
	        > 要求しない
	        <input type="radio" name="englishLevel" id="englishLevel" value="1"
	         <c:if test="${searchBean.wk001Bean.englishLevel == 1}"> checked </c:if>
	        > Ａ：ネイティブレベル 
			<input type="radio" name="englishLevel" id="englishLevel" value="2"
			 <c:if test="${searchBean.wk001Bean.englishLevel == 2}"> checked </c:if>
			> Ｂ：ビジネスレベル 
			<input type="radio" name="englishLevel" id="englishLevel" value="3"
			 <c:if test="${searchBean.wk001Bean.englishLevel == 3}"> checked </c:if>
			> Ｃ：挨拶程度or自信なし </p>
	<div>業務分類：
		<select id="level1Id" name="level1Id">
				<option value=0>選択</option>
				  <c:forEach items="${searchBean.linkageBean.mst001List}" var="mst001Bean">
			        <option value ="${mst001Bean.level1Id}" 
			          <c:if test="${mst001Bean.level1Id == searchBean.linkageBean.selectedLevel1Id }"> selected </c:if>
			        ><c:out value="${mst001Bean.name}"/>
			        </option>
			      </c:forEach>
			</select><br>
			<div id="level2Area">
			<select id="level2Id" name="level2Id" onChange='level2_changed()'>
				<option value=0>選択</option>
				  <c:forEach items="${searchBean.linkageBean.mst002List}" var="mst002Bean">
			          <option value ="${mst002Bean.level2Id}" 
			            <c:if test="${mst002Bean.level2Id == searchBean.linkageBean.selectedLevel2Id }"> selected </c:if>
			          ><c:out value="${mst002Bean.name}"/></option>
			      </c:forEach>
			</select><br>
			<div id="level3Area">
			<select id="level3Id" name="level3Id">
				<option value=0>選択</option>
				  <c:forEach items="${searchBean.linkageBean.mst003List}" var="mst003Bean">
			          <option value ="${mst003Bean.level3Id}" 
			            <c:if test="${mst003Bean.level3Id == searchBean.linkageBean.selectedLevel3Id }"> selected </c:if>
			        ><c:out value="${mst003Bean.name}"/></option>
			      </c:forEach>
			</select>
			</div>
			</div>
    </div>
	<p>氏名：<input type="text" name="name" value="${searchBean.wk001Bean.name}"></p>
	<input type="submit" name="Submit" value="検索">
</form>
<hr size="4">
<h2>検索結果一覧</h2>
<table border="1">
    	<tr>
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
      		<th>手数料（消費税込み）</th>
      		<th>国内/海外</th>
      		<th>登録番号</th>
    	</tr>
    	<c:forEach items="${disp001List}" var="disp001Bean">
    		<c:set var="wk001Bean" value="${disp001Bean.wk001Bean}" />
    		<c:set var="wk004List" value="${disp001Bean.wk004List}" />
    		<%-- disp004Sizeの長さ，一行目の<td rowspan="？"> を決定する--%>
    		<c:set var="disp004Size" value="${fn:length(wk004List)}" />
    		<%-- disp004Sizeの長さ最低値は1。wk004Listの長さは0の場合、１に設定する --%>
    		<c:if test="${wk004List== null || fn:length(wk004List) == 0}">
    			<c:set var="disp004Size" value="1" />
    		</c:if>
    		
    		<%-- 最初のレコードは、すべて<TR>を表示する。（wk001Bean和wk004List最初のレコード。） --%>
    		  <tr>
			    <td rowspan="${disp004Size}"><fmt:formatDate value="${wk001Bean.receptionDay}" pattern="yyyy/MM/dd" /></td>
			    <td rowspan="${disp004Size}"><c:out value="${wk001Bean.name}" /></td>
			    <td rowspan="${disp004Size}"><fmt:formatDate value="${wk001Bean.birthDay}" pattern="yyyy/MM/dd" /></td>
			    <td rowspan="${disp004Size}"><c:out value="${wk001Bean.address}" /></td>
			    <td><c:out value="${wk004List[0].hopePosition}" /></td>
			    <td><c:out value="${wk004List[0].forBusiness}" /></td>
			    <td><fmt:formatDate value="${wk004List[0].introductionDay}" pattern="yyyy/MM/dd" /></td>
			    <td><fmt:formatDate value="${wk004List[0].interviewDay}" pattern="yyyy/MM/dd" /></td>
			    <td rowspan="${disp004Size}"><fmt:formatDate value="${wk001Bean.inaugurationDay}" pattern="yyyy/MM/dd" /></td>
			    <td rowspan="${disp004Size}"><fmt:formatDate value="${wk001Bean.turnoverDay}" pattern="yyyy/MM/dd" /></td>
			    <td rowspan="${disp004Size}"><c:out value="${wk001Bean.fee}" /></td>
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
			  </tr>
    		</c:forEach>
    	</c:forEach>
	</table><br />
</body>
</html>