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
<title>求人管理簿詳細画面</title>
</head>
<script type="text/javascript">
function submit_update() {
	document.getElementById("form1").action = "ListSecondModify";
	if (!confirm("更新してよろしいですか？")) {
		return;
	}
	document.getElementById("form1").submit();
}
function popup_window(thisTextArea) {
	document.getElementById("fatherText").value = thisTextArea.value;
	if(thisTextArea.name == "recruitmentFrom"){
		document.getElementById("popTitle").value = "求人事業者からの求人票";
	}
	else if(thisTextArea.name == "recruitmentOwn"){
		document.getElementById("popTitle").value = "自社の求人票";
	}
	
	var returnValue= window.showModalDialog("pop.jsp",window,"dialogHeight=600px;dialogWidth=700px;dialogLeft=0px;dialogTop=0px;center=yes;resizable=no;status=no;scroll=yes;help=no;");
	if (returnValue != null )
   {
		thisTextArea.value = returnValue;
   }
	return false;
}
function pop_multi_select(thisText) {
	document.getElementById("currentMainIdInput").value = thisText.value;
	var returnValue= window.showModalDialog("PopMainIdSelect",window,"dialogHeight=600px;dialogWidth=700px;dialogLeft=0px;dialogTop=0px;center=yes;resizable=no;status=no;scroll=yes;help=no;");
	if (returnValue != null )
   {
		thisText.value = returnValue;
   }
	return false;
}
function new_data006(){
	var data=$('<table border="1"> <tr><td><input type="checkbox" name="del"></td><td><input type="text" name="receptionDay" value="${wk006Bean.receptionDay}"></td><td><input type="text" name="quantity" value="${wk006Bean.quantity}"></td><td><input type="text" name="occupation" value="${wk006Bean.occupation}"></td><td><input type="text" name="workLocation" value="${wk006Bean.workLocation}"></td><td><input type="text" name="period" value="${wk006Bean.period}"></td><td><input type="text" name="wage" value="${wk006Bean.wage}"></td><td><input type="text" name="conditions" value="${wk006Bean.conditions}"></td><td><input type="text" name="place" value="${wk006Bean.place}"></td><td><textarea name="recruitmentFrom" onclick="popup_window(this)"><c:out value="${wk006Bean.recruitmentFrom}"/></textarea></td><td><textarea name="recruitmentOwn" onclick="popup_window(this)"><c:out value="${wk006Bean.recruitmentOwn}" /></textarea></td><td><input type="text" name="secondMainId" onclick="pop_multi_select(this)" value="${wk006Bean.mainId}"></td></tr></table>');
		$('#data006PageAdd').before(data);
}
function delete_data006(){
	var checkboxList = document.getElementsByName("del");
	for(var i=0; i<checkboxList.length; i++){
		if(checkboxList[i].checked){
			checkboxList[i].checked = false;
			document.getElementsByName("receptionDay")[i].value = '';
			document.getElementsByName("quantity")[i].value = '';
			document.getElementsByName("occupation")[i].value = '';
			document.getElementsByName("workLocation")[i].value = '';
			document.getElementsByName("period")[i].value = '';
			document.getElementsByName("wage")[i].value = '';
			document.getElementsByName("conditions")[i].value = '';
			document.getElementsByName("place")[i].value = '';
			document.getElementsByName("recruitmentFrom")[i].value = '';
			document.getElementsByName("recruitmentOwn")[i].value = '';
			document.getElementsByName("secondMainId")[i].value = '';
		}
	}
}
</script>
<body bgcolor="gray">
	<form name="form1" id="form1" method="post" action="ListSecondAdd">
		<input type="hidden" id="tradeId" name="tradeId" value="${disp002Bean.wk005Bean.tradeId}"> 
		<!-- こちらのcurrentMainIdInputは、pop window(mainId select)のため -->
		<input type="hidden" id="currentMainIdInput" name="currentMainIdInput" value="">
		<!-- こちらのshowTextは、pop windowのため -->
		<input type="hidden" id="fatherText" name="fatherText" value="">
		<!-- pop windowで、displayではないなら、textareaが変更できるように -->
		<input type="hidden" id="optionView" name="optionView" value="">
		<!-- pop windowのタイトル-->
		<input type="hidden" id="popTitle" name="popTitle" value="">
		<div align="center">
		<h2>求人管理簿</h2>
		<p>求人事業所：<input type="text" name="forBusiness" value="${disp002Bean.wk005Bean.forBusiness}"></p>
		<p>所在地：<input type="text" name="address" value="${disp002Bean.wk005Bean.address}"></p>
		<p>代表者氏名：<input type="text" name="representative" value="${disp002Bean.wk005Bean.representative}"></p>
		<p>連絡担当者：<input type="text" name="charger" value="${disp002Bean.wk005Bean.charger}"></p>
		<p>備考：<textarea name="remarks"><c:out value="${disp002Bean.wk005Bean.remarks}" /></textarea></p>
		</div>
		<hr>
	<table border="1">
		<tr>
      		<th>選択</th>
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
    	<c:choose>
				<c:when test="${fn:length(disp002Bean.wk006List)==0}">
					<tr>
      					<td><input type="checkbox" name="del" id="del"></td>
      					<td><input type="text" name="receptionDay" id="receptionDay" value=""></td>
      					<td><input type="text" name="quantity" id="quantity" value=""></td>
      					<td><input type="text" name="occupation" id="occupation" value=""></td>
      					<td><input type="text" name="workLocation" id="workLocation" value=""></td>
      					<td><input type="text" name="period" id="period" value=""></td>
      					<td><input type="text" name="wage" id="wage" value=""></td>
      					<td><input type="text" name="conditions" id="conditions" value=""></td>
      					<td><input type="text" name="place" id="place" value=""></td>
      					<td><textarea name="recruitmentFrom" id="recruitmentFrom" onclick="popup_window(this)"><c:out value=""/></textarea></td>
      					<td><textarea name="recruitmentOwn" id="recruitmentOwn" onclick="popup_window(this)"><c:out value="" /></textarea></td>
      					<td><input type="text" name="secondMainId" id="secondMainId" onclick="pop_multi_select(this)" value=""></td>
    				</tr>		
				</c:when> 
				<c:otherwise>
					<c:forEach items="${disp002Bean.wk006List}" var="wk006Bean">
						<tr>
      						<td><input type="checkbox" name="del"></td>
      						<td><input type="text" name="receptionDay" id="receptionDay" value="${wk006Bean.receptionDay}"></td>
      						<td><input type="text" name="quantity" id="quantity" value="${wk006Bean.quantity}"></td>
      						<td><input type="text" name="occupation" id="occupation" value="${wk006Bean.occupation}"></td>
      						<td><input type="text" name="workLocation" id="workLocation" value="${wk006Bean.workLocation}"></td>
      						<td><input type="text" name="period" id="period" value="${wk006Bean.period}"></td>
      						<td><input type="text" name="wage" id="wage" value="${wk006Bean.wage}"></td>
      						<td><input type="text" name="conditions" id="conditions" value="${wk006Bean.conditions}"></td>
      						<td><input type="text" name="place" id="place" value="${wk006Bean.place}"></td>
      						<td><textarea name="recruitmentFrom" id="recruitmentFrom" onclick="popup_window(this)"><c:out value="${wk006Bean.recruitmentFrom}"/></textarea></td>
      						<td><textarea name="recruitmentOwn" id="recruitmentOwn" onclick="popup_window(this)"><c:out value="${wk006Bean.recruitmentOwn}" /></textarea></td>
      						<td><input type="text" name="secondMainId" id="secondMainId" onclick="pop_multi_select(this)" value="${wk006Bean.secondMainId}"></td>
      					</tr>
					</c:forEach> 
				</c:otherwise>
			</c:choose>
	</table>
	
	<input type="button" value="追加" id="data006PageAdd" onclick="new_data006();">
	<input type="button" value="削除" id="data006PageDel" onclick="delete_data006();">
		
			<c:choose>
				<c:when test="${disp002Bean.wk005Bean.tradeId> 0}">
					<input type="button" onclick="submit_update();" value="更新">
				</c:when>
				<c:otherwise>
					<input type="submit" name="Submit" value="登録">
				</c:otherwise>
			</c:choose>
		
	</form>

</body>
</html>