<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>popup window</title>
</head>
<body>
<form>
<label id="label_title"><c:out value="${popTitle}" /></label>
<textarea id="childText" name="childText" rows="30" cols="80"><c:out value="${dispContent}" /></textarea><br>
 <input id="btn_close" type="button" onclick="window.close();" value="閉じる">
</form>
</body>
</html>