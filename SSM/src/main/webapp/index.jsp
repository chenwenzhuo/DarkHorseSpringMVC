<%--
  Created by IntelliJ IDEA.
  User: Chenwz
  Date: 2019/12/23 0023
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll">查询所有账户信息</a>
<hr/>
<h3>测试保存</h3>
<form action="account/save" method="post" accept-charset="UTF-8">
    <label>
        账户名：<input type="text" name="name"/><br/>
    </label>
    <label>
        金额：<input type="text" name="money"/><br/>
    </label>
    <label>
        <input type="submit" value="保存"/><br/>
    </label>
</form>
</body>
</html>
