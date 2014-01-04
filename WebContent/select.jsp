<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
.button {
	width:300px;
	height:80px;
	font-size: 30px;
	border-radius: 5px;
}
</style>
</head>
<script type="text/javascript">
	function submit_kyusyoku() {
		document.getElementById("form1").action = "ListShow";
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
<body style="margin-top:50px">
<form name="form1" id="form1" method="post" action="">
<div align="center">
<h1>人材管理簿</h1>
<p><input class="button" type="button" value="求職管理簿" onclick="submit_kyusyoku();"></p>
<p><input class="button" type="button" value="求人管理簿" onclick="submit_kyujinn();"></p>
<p><input class="button" type="button" value="手数料管理簿" onclick="submit_fee();"></p>
</div>
</form>
</body>
</html>