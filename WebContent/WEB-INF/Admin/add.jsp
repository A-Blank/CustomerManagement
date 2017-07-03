<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function onClick(){
		var username=document.getElementById("username").value;
		var male=document.getElementById("male");
		var female=document.getElementById("female");
		var birthday=document.getElementById("birthday").value;
        var result = birthday.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
		if(username==""||!(male.checked||female.checked)||birthday==""){
			alert("客户信息不完善!");
			return false;
		}else  if(result==null)
        {
            alert("请输入正确的日期格式");
            return false;
        }
		else{
			return true;
		}
	}
</script>

</head>
<body style="text-align: center;">
<h3 align="center">添加客户</h3>
<s:form action="addCustomer" method="post" namespace="/">
    <table border="0" align="center" width="40%" style="margin-left: 100px">
        <tr>
            <td width="100px">客户名称</td>
            <td width="40%">
                <input id="username" type="text" name="username" />
            </td>
        </tr>
        <tr>
            <td width="100px">客户性别</td>
            <td>
                <input type="radio" name="sex" value="男" id="male"/>
                <label for="男">男</label>
                <input type="radio" name="sex" value="女" id="female"/>
                <label for="女">女</label>
            </td>
            <td>
                <label id="genderError"class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td width="100px">客户生日</td>
            <td>
                 <input id="birthday" type="text" name="birthday"/>
            </td>
        </tr>
        <tr>
            <td>描述</td>
            <td width="300px" align="center">
                <textarea rows="5" cols="17" name="description"></textarea>
            </td>
      
        </tr>
        <tr>
        	<td></td>
            <td>
                <input type="submit" onclick="return onClick()" value="确认" name="submit"/>
                <input type="reset" name="reset"/>
            </td>
        </tr>
    </table>
</s:form>

</body>
</html>