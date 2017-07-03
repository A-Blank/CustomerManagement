<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="login" method="post" namespace="/" theme="simple">
<h3 style="text-align: center; text-decoration: none;"><s:actionerror/></h3>
<div style="text-align: center; margin: 5px;">
	<div>
		<h5>用户名</h5>
		<input type="text" name="username">
	</div>
	<div>
	<h5>密码</h5>
		<input type="password" name="password">
	</div>
	<div style="margin-top: 10px;">
		<input type="submit" value="登录">
	</div>
</div>

</s:form>
</body>
</html>