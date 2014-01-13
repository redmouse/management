<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/list_detail.css">
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>求職管理簿詳細画面</title>
</head>
<script type="text/javascript">
function check_all_element() {
	//氏名 
	if($("#name").val().trim() == ""){
		return "氏名を入力してください！";
	}
	//年齢 
	reg=/^[1-9][0-9]$/;
	if(!reg.test($("#age").val().trim())){
		return "年齢を正しく入力してください！";
	}
	//生年月日 
	reg=/^\d{4}\/\d{2}\/\d{2}$/;
	if(!reg.test($("#birthDay").val().trim())){
		return "生年月日[yyyy/mm/dd]を正しく入力してください！";
	}
	//性別 
	if($(":radio[name='sex']:checked").size()==0){
		return "性別を選択してください！";
	}
	//自宅住所
	if($("#address").val().trim() == ""){
		return "自宅住所を入力してください！";
	}
	//電話: 数字{2-3桁} -{0-1桁} 数字{2-4桁} -{0-1桁} 数字{2-4桁} 
	reg=/^\d{2,3}-{0,1}\d{2,4}-{0,1}\d{2,4}$/;
	// 自宅電話と携帯電話両方空の場合
	if($("#homePhone").val().trim() == "" && $("#mobilePhone").val().trim() == ""){
		return "自宅電話又は携帯電話どちらを入力してください！";
	}
	if($("#homePhone").val().trim() != ""){
		if(!reg.test($("#homePhone").val().trim())){
			return "自宅電話を正しく入力してください！";
		}
	}
	if($("#mobilePhone").val().trim() != ""){
		if(!reg.test($("#mobilePhone").val().trim())){
			return "携帯電話を正しく入力してください！";
		}
	}
	// Ｅメール
	/* reg=/^[\w.-]+@[\w.-]+$/;
	if(!reg.test($("#email").val().trim())){
		return "Ｅメールを正しく入力してください！";
	} */
	//最終学歴
	if($("#lastDegree").val().trim() == ""){
		return "最終学歴を入力してください！";
	}
	//専攻
	if($("#specialty").val().trim() == ""){
		return "専攻を入力してください！";
	}
	//卒業年月日 
	reg=/^\d{4}\/\d{2}\/\d{2}$/;
	if(!reg.test($("#graduationDay").val().trim())){
		return "卒業年月日[yyyy/mm/dd]を正しく入力してください！";
	}
	//英語レベル
	if($(":radio[name='englishLevel']:checked").size()==0){
		return "英語レベルを選択してください！";
	}
	// 正常
	return "";
}
	// upload　ボタン
	function submit_upload() {
		document.getElementById("form_upload").submit();
	}
	// 戻る　ボタン
	function submit_list_show() {
		document.getElementById("form1").action = "ListShow";
		document.getElementById("form1").submit();
	}
	// 削除　ボタン
	function submit_list_delete(){
		document.getElementById("form1").action = "ListDelete";
		if(!confirm("削除してよろしいですか？")){
			return;
		}
		document.getElementById("form1").submit();
	}
	// 新規　ボタン
	function submit_pre_add(){
		document.getElementById("form1").action = "ListPreAdd";
		document.getElementById("form1").submit();
	} 
	// 検索　ボタン
	function submit_search(){
		document.getElementById("form1").action = "SearchPre";
		document.getElementById("form1").submit();
	} 
	// 更新　ボタン
	function submit_update() {
		document.getElementById("form1").action = "ListModify";
		var errMsg = check_all_element();
		if(errMsg != ""){
			alert(errMsg);
			return;
		}
		if (!confirm("更新してよろしいですか？")) {
			return;
		}
		document.getElementById("form1").submit();
	}
	// 登録　ボタン
	function submit_insert() {
		document.getElementById("form1").action = "ListAdd";
		var errMsg = check_all_element();
		if(errMsg != ""){
			alert(errMsg);
			return;
		}
		if (!confirm("新規してよろしいですか？")) {
			return;
		}
		document.getElementById("form1").submit();
	}
	//新規登録と更新する時の最初画面の設定
	function setDetail() {
		if ('${detailBean.wk001Bean.place}' == 1) {
			document.all("place")[0].checked = true;
			document.all("place")[1].checked = false;
		} else if('${detailBean.wk001Bean.place}' == 2) {
			document.all("place")[0].checked = false;
			document.all("place")[1].checked = true;
		}
		if ('${detailBean.wk001Bean.sex}' == 1) {
			document.all("sex")[0].checked = true;
			document.all("sex")[1].checked = false;
		} else if('${detailBean.wk001Bean.sex}' == 2) {
			document.all("sex")[0].checked = false;
			document.all("sex")[1].checked = true;
		}
		if ('${detailBean.wk001Bean.marriage}' == 1) {
			document.all("marriage")[0].checked = true;
			document.all("marriage")[1].checked = false;
		} else if('${detailBean.wk001Bean.marriage}' == 2) {
			document.all("marriage")[0].checked = false;
			document.all("marriage")[1].checked = true;
		}
		if ('${detailBean.wk001Bean.department}' == 1) {
			document.all("department")[0].checked = true;
		} else if ('${detailBean.wk001Bean.department}' == 2) {
			document.all("department")[1].checked = true;
		} else if ('${detailBean.wk001Bean.department}' == 3){
			document.all("department")[2].checked = true;
		}
		if ('${detailBean.wk001Bean.englishLevel}' == 1) {
			document.all("englishLevel")[0].checked = true;
		} else if ('${detailBean.wk001Bean.englishLevel}' == 2) {
			document.all("englishLevel")[1].checked = true;
		} else if ('${detailBean.wk001Bean.englishLevel}' == 3) {
			document.all("englishLevel")[2].checked = true;
		}
		if ('${detailBean.wk001Bean.bachelor}' == 1) {
			document.all("bachelor")[0].checked = true;
		} else if('${detailBean.wk001Bean.bachelor}' == 2)  {
			document.all("bachelor")[1].checked = true;
		}
		if ('${detailBean.wk001Bean.foreigner}' == 1) {
			document.all("foreigner").setAttribute("checked", true);
		} 
	}

	// ---------- Jquery  -----------
$(document).ready(function(){
	$("#level1Id").change(function(){
		$("#level2Area").load("Linkage",{level1Id:$("#level1Id  option:selected").val()});
		});
});
	
function level2_changed(){
	$("#level3Area").load("Linkage",{level2Id:$("#level2Id  option:selected").val()});
}

function new_data(){
	var data=$('<div style="border: 2px solid;width: 400px;">希望職種	<input type="text" name="hopePosition" id="hopePosition" value=""><br>求人事業者<input type="text" name="forBusiness" id="forBusiness" value=""><br>紹介年月日<input type="text" name="introductionDay" id="introductionDay" value=""><br>面接日時<input type="text" name="interviewDay" id="interviewDay" value=""><br></div>');
	$('#next').before(data);
}

 /* function testdata() {
		document.getElementsByName("dispMainId")[0].value = "00010";
		document.getElementsByName("receptionDay")[0].value = "2013/09/12";
		document.getElementsByName("name")[0].value = "次郎";
		document.getElementsByName("hurigana")[0].value = "ジロウ";
		document.getElementsByName("birthDay")[0].value = "2013/09/12";
		document.getElementsByName("graduationDay")[0].value = "2013/09/12";
		//	document.getElementsByName("hopePosition")[0].value="取締り";
		//	document.getElementsByName("forBusiness")[0].value="会社名";
		//	document.getElementsByName("introductionDay")[0].value="2013/09/12";
		//	document.getElementsByName("interviewDay")[0].value="2013/09/12";
		document.getElementsByName("inaugurationDay")[0].value = "2013/09/12";
		document.getElementsByName("turnoverDay")[0].value = "2013/09/12";
		setRadioValue("sex", "1");
		document.getElementsByName("age")[0].value = "25";
	}

	function setRadioValue(radioName, val) {
		var radios = document.getElementsByName(radioName);
		if (!radios)
			return '';
		for ( var i = 0; i < radios.length; i++) {
			if (radios[i].value == val) {
				radios[i].checked = true;
			} else {
				radios[i].checked = false;
			}
		}
		return '';
	}   */
</script>
<body onload="setDetail();">
  <div id="container">
	<form name="form1" id="form1" method="post" action="">
		<input type="hidden" id="mainId" name="mainId" value="${detailBean.wk001Bean.mainId}"> 
		<input type="hidden" id="del" name="del" value="${detailBean.wk001Bean.mainId}"> 
		<input type="hidden" id="linkageOpt" name="linkageOpt"> 
		<!-- <input type="button" onclick="testdata();" value="testdata"> -->
		<div id="header"> 
	　　　 <ul style="list-style-type: none">
	　　　<li><input type="button" onclick="submit_list_show()" value="戻る"></li>
	　　　<li id="title">▽ 人材情報データベース </li>
	　　　 <li id="add"><input type="button" onclick="submit_pre_add()" value="新規"></li> 
	　　　 <li><input type="button" onclick="submit_search()" value="検索"></li> 
	    <li><input type="submit" name="Submit" value="印刷"></li>
	    <li><input type="button" onclick="submit_list_delete()" value="削除"></li>
		</ul>
		</div><!-- header -->
		<p>
			登録番号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="dispMainId" id="dispMainId" style="background-color:gray"
				value="${detailBean.wk001Bean.dispMainId}" readOnly> ※自動生成 
			受付日時<input type="text" name="receptionDay" id="receptionDay"
				value='<fmt:formatDate value="${detailBean.wk001Bean.receptionDay}" pattern="yyyy/MM/dd" />'>
		</p>
		<p>
			業務分類 <br> ※3項目選択
		    <select id="level1Id" name="level1Id">
				<option value=0>選択</option>
				  <c:forEach items="${detailBean.linkageBean.mst001List}" var="mst001Bean">
			        <option value ="${mst001Bean.level1Id}" 
			          <c:if test="${mst001Bean.level1Id == detailBean.linkageBean.selectedLevel1Id }"> selected </c:if>
			        ><c:out value="${mst001Bean.name}"/>
			        </option>
			      </c:forEach>
			</select><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="level2Area">
			<select id="level2Id" name="level2Id" onChange='level2_changed()' style="width:278px">
				<option value=0>選択</option>
				  <c:forEach items="${detailBean.linkageBean.mst002List}" var="mst002Bean">
			          <option value ="${mst002Bean.level2Id}" 
			            <c:if test="${mst002Bean.level2Id == detailBean.linkageBean.selectedLevel2Id }"> selected </c:if>
			          ><c:out value="${mst002Bean.name}"/></option>
			      </c:forEach>
			</select><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="level3Area">
			<select id="level3Id" name="level3Id" style="width:272px;display:none">
				<option value=0>選択</option>
				  <c:forEach items="${detailBean.linkageBean.mst003List}" var="mst003Bean">
			          <option value ="${mst003Bean.level3Id}" 
			            <c:if test="${mst003Bean.level3Id == detailBean.linkageBean.selectedLevel3Id }"> selected </c:if>
			        ><c:out value="${mst003Bean.name}"/></option>
			      </c:forEach>
			</select>
			</span>
			</span>
		</p>
		<p>
			国内/海外&nbsp;&nbsp; 
			<input type="radio" name="place" id="place" value="1">国内
			<input type="radio" name="place" id="place" value="2">海外
		</p>
		<p>
			<span class="star">☆</span>氏名&nbsp; <input type="text" name="name" id="name" value="${detailBean.wk001Bean.name}">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ふりがな<input type="text" name="hurigana" id="hurigana" value="${detailBean.wk001Bean.hurigana}">
		</p>
		<p>
			<span class="star">☆</span>年齢&nbsp;&nbsp;<input type="text" name="age" id="age" value='<c:if test="${detailBean.wk001Bean.age!=0}"><c:out value="${detailBean.wk001Bean.age}"/></c:if>'> 
			<span class="star">☆</span>生年月日<input type="text" name="birthDay" id="birthDay"
				value='<fmt:formatDate value="${detailBean.wk001Bean.birthDay}" pattern="yyyy/MM/dd" />'>
		</p>
		<p>
			<span class="star">☆</span>性別 
			<input type="radio" name="sex" id="sex" value="1"> 男性 
			<input type="radio" name="sex" id="sex" value="2">女性 ｜ 
			<input type="radio" name="marriage" id="marriage" value="1">既婚 
			<input type="radio" name="marriage" id="marriage" value="2">未婚 ｜ 
			<input type="checkbox" name="foreigner" value="1">外国人
		</p>
		<p>
			郵便番号
			<input type="text" name="postcode" id="postcode" value="${detailBean.wk001Bean.postcode}">
			<span class="star">☆</span>自宅住所
			<textarea name="address" id="address">${detailBean.wk001Bean.address}</textarea>
		</p>
		<p>
			家族
			<textarea name="family" id="family">${detailBean.wk001Bean.family}</textarea>
			<span class="star">☆</span>自宅電話
			<input type="text" name="homePhone" id="homePhone" value="${detailBean.wk001Bean.homePhone}">
			<!-- (例：***-****-****) -->
			<span class="star">☆</span>携帯電話
			<input type="text" name="mobilePhone" id="mobilePhone" value="${detailBean.wk001Bean.mobilePhone}">
		</p>
		<p>
			連絡方法&nbsp;&nbsp;&nbsp;&nbsp;
			 <input type="text" name="contactMethod" id="contactMethod" value="${detailBean.wk001Bean.contactMethod}"> 
			 Ｅメール
			 <input type="text" name="email" id="email" value="${detailBean.wk001Bean.email}">
		</p>
		<p>
			<span class="star">☆</span>最終学歴
			<input type="text" name="lastDegree" id="lastDegree" value="${detailBean.wk001Bean.lastDegree}">
		</p>
		<p>
			<span class="star">☆</span>専攻&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" name="specialty" id="specialty" value="${detailBean.wk001Bean.specialty}"> 
			<input type="radio" name="department" id="department" value="1">理系
			<input type="radio" name="department" id="department" value="2">文系
			<input type="radio" name="department" id="department" value="3">その他・・・
		</p>
		<p>
			<span class="star">☆</span>卒業年月日
			<input type="text" name="graduationDay" id="graduationDay"
				value='<fmt:formatDate value="${detailBean.wk001Bean.graduationDay}" pattern="yyyy/MM/dd" />'>
			学校その他
			<input type="text" name="schoolOther" id="schoolOther" value="${detailBean.wk001Bean.schoolOther}">
		</p>
		
		<div id="enself">
			<div id="english"><span class="star">☆</span>英語レベル<br> 
				<input type="radio" name="englishLevel" id="englishLevel" value="1"> Ａ：ネイティブレベル<br> 
				<input type="radio" name="englishLevel" id="englishLevel" value="2"> Ｂ：ビジネスレベル <br> 
				<input type="radio" name="englishLevel" id="englishLevel" value="3"> Ｃ：挨拶程度or自信なし 
			</div>
			<div id="self">自己評価：<br>
				<textarea rows="8" cols="50" name="selfAssessment" id="selfAssessment">
					${detailBean.wk001Bean.selfAssessment}
				</textarea>
			</div>
		</div><!-- enself  -->
			<p>
				ＴＯＥＩＣ：<input type="text" name="toeic" id="toeic" value="${detailBean.wk001Bean.toeic}">
		       	ＴＯＥＦＬ：<input type="text" name="toefl" id="toefl" value="${detailBean.wk001Bean.toefl}">
		                   英検：<input type="text" name="etest" id="etest" value="${detailBean.wk001Bean.etest}">
			</p>
		
			希望事項
			<textarea name="requirements" id="requirements">${detailBean.wk001Bean.requirements}</textarea>
		         年収「現状」
		    <input type="text" name="annualIncomeNow" id="annualIncomeNow" value="${detailBean.wk001Bean.annualIncomeNow}">
		         年収「希望」
		    <input type="text" name="annualIncomeHope" id="annualIncomeHope" value="${detailBean.wk001Bean.annualIncomeHope}">
		
		<p>
			希望勤務地
			<input type="text" name="workLocation" id="workLocation" value="${detailBean.wk001Bean.workLocation}"> 
			単身赴任 
			<input type="radio" name="bachelor" id="bachelor" value="1">ＯＫ 
			<input type="radio" name="bachelor" id="bachelor" value="2">ＮＯ
		</p>
		<p>
			就職年月日
			<input type="text" name="inaugurationDay" id="inaugurationDay"
				value='<fmt:formatDate value="${detailBean.wk001Bean.inaugurationDay}" pattern="yyyy/MM/dd" />'>
			離職日<input type="text" name="turnoverDay" id="turnoverDay"
				value='<fmt:formatDate value="${detailBean.wk001Bean.turnoverDay}" pattern="yyyy/MM/dd" />'>
			手数料（消費税込み）<input type="text" name="fee" id="fee" value="${detailBean.wk001Bean.fee}">
		</p>
		<div id="infocontents" style="overflow:hidden;">
			<div id="info" style="width:373px;height=110px;float:left;">会社情報<br>                                                                                             
				<textarea rows="8" cols="50" name="companyInfo" id="companyInfo"><c:out value="${detailBean.wk001Bean.companyInfo}" /></textarea>
			</div>
			<div id="contents" style="width:373px;height=110px;float:left;margin-left:10px;">業務内容<br>
				<textarea rows="8" cols="50" name="workContents" id="workContents"><c:out value="${detailBean.wk001Bean.workContents}" /></textarea>
			</div	> 
		</div><!-- infocontents -->
		
		<!-- 面談データ -->
		<div id="datafile" style="overflow:hidden;">
		  <div id="dataall" style="width:404px;height=108px;float:left;">
			面談データ<br>
		 <c:if test="${fn:length(detailBean.wk004List)==0}">
			<div id="data" style="border: 2px solid;width: 400px;">
				希望職種:<input type="text" name="hopePosition" id="hopePosition" value=""><br>
		                   求人事業者:<input type="text" name="forBusiness" id="forBusiness" value=""><br>
		    	紹介年月日:<input type="text" name="introductionDay" id="introductionDay" value=""><br>
		                  面接日時:<input type="text" name="interviewDay" id="interviewDay" value=""><br>
			</div>
		</c:if>
		<c:forEach items="${detailBean.wk004List}" var="wk004Bean">
			<div id="data" style="border: 2px solid;width: 400px;">
				希望職種:<input type="text" name="hopePosition" id="hopePosition" value="${wk004Bean.hopePosition}"><br>
		                   求人事業者:<input type="text" name="forBusiness" id="forBusiness" value="${wk004Bean.forBusiness}"><br>
		    	紹介年月日:<input type="text" name="introductionDay" id="introductionDay" value="${wk004Bean.introductionDay}"><br>
		                  面接日時:<input type="text" name="interviewDay" id="interviewDay" value="${wk004Bean.interviewDay}"><br>
		                <!-- <input type="text" name="fileid" id="uploadfileid" value="" style="display:none"><br> -->
			</div>
		</c:forEach> 
		<%--  <c:choose>
				<c:when test="${fn:length(detailBean.wk004List)==0}">
					<div style="border: 2px solid;width: 400px;">
						希望職種:<input type="text" name="hopePosition" id="hopePosition" value=""><br>
		                                     求人事業者:<input type="text" name="forBusiness" id="forBusiness" value=""><br>
		    	                  紹介年月日:<input type="text" name="introductionDay" id="introductionDay" value=""><br>
		                                     面接日時:<input type="text" name="interviewDay" id="interviewDay" value=""><br>
					</div> 
				</c:when> 
				<c:otherwise>
					<c:forEach items="${detailBean.wk004List}" var="wk004Bean">
						<div id="data" style="border: 2px solid;width: 400px;">
							希望職種:<input type="text" name="hopePosition" id="hopePosition" value="${wk004Bean.hopePosition}"><br>
		                  	 求人事業者:<input type="text" name="forBusiness" id="forBusiness" value="${wk004Bean.forBusiness}"><br>
		    				紹介年月日:<input type="text" name="introductionDay" id="introductionDay" value="${wk004Bean.introductionDay}"><br>
		                                               面接日時:<input type="text" name="interviewDay" id="interviewDay" value="${wk004Bean.interviewDay}"><br>
		                <!-- <input type="text" name="fileid" id="uploadfileid" value="" style="display:none"><br> -->
						</div>
					</c:forEach> 
				</c:otherwise>
			</c:choose>
		 --%>
		<input type="button" value="次へ" id="next" onclick="new_data();">
		</div>
		

	</form>

<form id="form_file_list" action="" method="post">
<script type="text/javascript">
function submit_file_download(fileName){
	document.getElementById("fileName").value = fileName;
	document.getElementById("form_file_list").action = "Download";
	document.getElementById("form_file_list").submit();
}
function submit_file_delete(fileName){
	if (!confirm(fileName + " を削除してよろしいですか？")) {
		return;
	}
	document.getElementById("fileName").value = fileName;
	document.getElementById("form_file_list").target= "ajaxifr";
	document.getElementById("form_file_list").action = "FileDelete";
	document.getElementById("form_file_list").submit();
}
</script>
	<input type="hidden" id="mainId" name="mainId" value="${detailBean.wk001Bean.mainId}">
	<input type="hidden" id="fileName" name="fileName">
		<div id="file_list_html">
		<table border="1">
			<tr>
				<th>ファイル一覧</th>
				<th>ダウンロード</th>
				<th>削除</th>
			</tr>
				<c:forEach items="${detailBean.fileNameList}" var="fileName">
					<tr>
						<td><c:out value="${fileName}" /></td>
						<td><a href="#" onclick="submit_file_download('${fileName}');return false;">ダウンロード</a></td>
						<td><a href="#" onclick="submit_file_delete('${fileName}');return false;">削除</a></td>
					</tr>
				</c:forEach>
		</table>
		</div>
	<br />
	</div><!-- datafile -->
</form>
	
<script type="text/javascript">
   function recreateFileList(file_list_html){
	   document.getElementById('file_list_html').innerHTML= file_list_html;
      return;
   }
</script>
<iframe name="ajaxifr" style="display:none"></iframe>
<form id="form_upload" name="form_upload" method="post" enctype="multipart/form-data" action="UploadJfr" target="ajaxifr">
  　　 <input type="hidden" id="mainId" name="mainId" value="${detailBean.wk001Bean.mainId}">   
    <input type="file" name="file" value=""/><br >
</form>
<!-- button -->
	<input type="button" onclick="submit_upload();" value="upload" />
<p>
	<c:choose>
		<c:when test="${detailBean.optType == 'modify'}">
			<input type="button" onclick="submit_update();" value="更新">
		</c:when>
		<c:otherwise>
			<input type="button" onclick="submit_insert();" value="登録">
		</c:otherwise>
	</c:choose>
</p>

<p>Human Dream</p>
  </div><!-- container -->

</body>
</html>



