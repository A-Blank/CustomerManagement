<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
    <h3 align="center" >客户列表</h3>
    <table border="1" width="70%" align="center">
        <tr>
            <th>客户姓名</th>
            <th>性别</th>
            <th>生日</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
       	<s:iterator value="list" var="u">
        <tr>
            <td><s:property value="#u.username" /></td>
            <td><s:property value="#u.sex" /></td>
            <td><s:date name="#u.birthday" format="yyyy-MM-dd"/></td>
            <td><s:property value="#u.description" /></td>
            <td>
                <a href="${ pageContext.request.contextPath }/edit.action?uid=<s:property value="#u.uid"/> ">编辑</a>
                <a href="${ pageContext.request.contextPath }/delete.action?uid=<s:property value="#u.uid"/> ">删除</a>
            </td>
        </tr>
        </s:iterator>
    </table>
<br/>
<table align="center">
   <tr>
   	<td>
   		<s:if test="totalCount!=0">
	   		<span>第<s:property value="currPage" />/<s:property value="totalPage"/>页</span>
	   		<span>总记录数:<s:property value="totalCount" />每页显示:<s:property value="pageSize"/>条</span>
		   			<s:if test="currPage != 1">
		   				<a href="${ pageContext.request.contextPath }/findAll.action?currPage=1">[首页]</a>
		   				<a href="${ pageContext.request.contextPath }/findAll.action?currPage-1">[上一页]</a>
		   			</s:if>
		   			<s:if test="currPage != totalPage">
		   				<a href="${ pageContext.request.contextPath }/findAll.action?currPage+1">[下一页]</a>
		   				<a href="${ pageContext.request.contextPath }/findAll.action?currPage=totalPage">[上一页]</a>
		   			</s:if>
	   	</s:if>
	   	<s:else>
	   		<span>暂无数据</span>
	   	</s:else>
   	</td>
   </tr>
</table>
</body>
</html>