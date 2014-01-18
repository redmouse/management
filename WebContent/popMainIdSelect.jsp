<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
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
    k.document.getElementById("currentMainIdInput").value; 
   
	
	return;
}
// '00012,00014,00016-田中,黒田,山口'の形で戻す
function update_ok(){
	var mainIdStr = '';
	var nameStr = '';
	$('#select2 option').each(function(i) {
		// option.value = '00012-田中'の形
		var value = $(this).val();
        var mainId = getMainId(value);
        var name = getName(value);
		if(mainIdStr!=''){
			mainIdStr += ",";
		}
		if(nameStr!=''){
			nameStr += ",";
		}
        mainIdStr += mainId;
        nameStr += name;
      }); 
	window.returnValue = mainIdStr + '-' + nameStr;
	window.close();
}
function getMainId(optValue){
	var pos = optValue.indexOf("-");
	return optValue.substr(0,pos);
}
function getName(optValue){
	var pos = optValue.indexOf("-");
	return optValue.substr(pos+1);
}
// 左右移动
$(document).ready(function(){  
    $('#add').click(function(){  
        var $options = $('#select1 option:selected');//選んだ項目を取得
        var $remove = $options.remove();//選んだ項目をリストから削除  
        $remove.appendTo('#select2');//相手のリストに追加
    });  
      
    $('#remove').click(function(){  
        var $removeOptions = $('#select2 option:selected');  
        $removeOptions.appendTo('#select1');//削除と追加appendTo()を使う
    });  
      
    $('#addAll').click(function(){  
        var $options = $('#select1 option');  
        $options.appendTo('#select2');  
    });  
      
    $('#removeAll').click(function(){  
        var $options = $('#select2 option');  
        $options.appendTo('#select1');  
    });  
      
    //ダブルクリック  
    $('#select1').dblclick(function(){  
        var $options = $('option:selected', this);//option:selectedの間に空いてはいけない 
        $options.appendTo('#select2');  
    });  
      
    $('#select2').dblclick(function(){  
        $('#select2 option:selected').appendTo('#select1');  
    });  
    
    // 親ウィンドにあった値を取得、optionの移動を行う
    var k=window.dialogArguments;
    if(k!=null) { 
	    // 親ウィンドウの値を取得
	    var currentIds = k.document.getElementById("currentMainIdInput").value;
	    $('#select1 option').each(function(){
            var value = $(this).val();
         	// option.value = '00012-田中'の形
            var mainId = getMainId(value);
            // 左のmainIdは親ウィンドのmainIdに含まれたら、右に移動する。
            if (currentIds.indexOf(mainId) >= 0) {
	            $(this).appendTo('#select2');
            }
        });
    } 
   	
});  

</script>
<body onload="load_func()">
<form>
 
 <table>
	 <tr>
	 	<td>
	 	求人選択一覧<br/>
	 	名前 | 生年月日 | 受付年月日 | 希望職種 | 求人事業者<br/>
		 <select id="select1" multiple="multiple" size="10" style="width:600px">
		 	<c:forEach items="${disp001List}" var="disp001Bean">
		 	    <c:set var="wk001Bean" value="${disp001Bean.wk001Bean}" />
    		    <c:set var="wk004List" value="${disp001Bean.wk004List}" />
				<option value ="${wk001Bean.dispMainId}-${wk001Bean.name}">
				 <%--  <c:out value="${wk001Bean.dispMainId}" /> --%>
				    <c:out value="${wk001Bean.name}" />
				  | <fmt:formatDate value="${wk001Bean.birthDay}" pattern="yyyy/MM/dd" />
				  | <fmt:formatDate value="${wk001Bean.receptionDay}" pattern="yyyy/MM/dd" />
				  | 
				  <c:forEach items="${wk004List}" var="wk004Bean">
				  	  <c:out value="${wk004Bean.hopePosition}" /> 
				  </c:forEach>
				  | 
				  <c:forEach items="${wk004List}" var="wk004Bean">
					  <c:out value="${wk004Bean.forBusiness}" />
				  </c:forEach>
				</option>
			</c:forEach>
		</select>
		</td>
	 </tr>
	 <tr>
	 	<td align="center">
	 		<input id="add" type="button" value="▼">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 		<input id="remove" type="button" value="▲">
	 	</td>
	 </tr>
	 <tr>
	 	<td>
	 	選択済み一覧<br/>
		 <select id="select2" multiple="multiple" size="10" style="width:600px"></select>
		</td>
	 </tr>
 </table>
 <br/>
<input type="button" onclick="window.close();" value="キャンセル">
 <input type="button" onclick="update_ok()" value="確定">
</form>
</body>
</html>