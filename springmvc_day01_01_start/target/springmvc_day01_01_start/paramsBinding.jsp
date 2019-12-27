<%--
  Created by IntelliJ IDEA.
  User: Chenwz
  Date: 2019/11/28 0028
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>
<!--
<%--向后台传递参数--%>
<%--传递简单类型参数--%>
<a href="paramsBinding/testParamsBinding?username=tom&age=25">传递请求参数</a>
<br/><br/>

<%--将参数封装进实体类对象--%>
<form action="paramsBinding/saveAccount" method="post">
    <%--实体类的简单类型属性--%>
    账户名：<label><input type="text" name="accountName" value="恰恰恰"/></label><br/>
    密码：<label><input type="text" name="password" value="111"/></label><br/>
    金额：<label><input type="text" name="money" value="12.34"/></label><br/><br/>

        <%--实体类的引用类型属性--%>
    用户名：<label><input type="text" name="user.username" value="我问问"/></label><br/>
    年龄：<label><input type="text" name="user.age" value="12"/></label><br/><br/>

        <%--实体类的集合类型属性--%>
    List-1-用户名：<label><input type="text" name="userList[0].username" value="嗯嗯嗯"/></label><br/>
    List-1-年龄：<label><input type="text" name="userList[0].age" value="23"/></label><br/>

    List-2-用户名：<label><input type="text" name="userList[1].username" value="仍然让"/></label><br/>
    List-2-年龄：<label><input type="text" name="userList[1].age" value="34"/></label><br/><br/>

    Map-1-用户名：<label><input type="text" name="userMap['one'].username" value="通天塔"/></label><br/>
    Map-1-年龄：<label><input type="text" name="userMap['one'].age" value="45"/></label><br/>

    Map-2-用户名：<label><input type="text" name="userMap['two'].username" value="应用于"/></label><br/>
    Map-2-年龄：<label><input type="text" name="userMap['two'].age" value="56"/></label><br/>
    <label><input type="submit" value="提交"/> </label>
</form>
-->

<form action="paramsBinding/saveProduct" method="post">
    产品名：<label><input type="text" name="productName" value="键盘"/></label><br/>
    价格：<label><input type="text" name="price" value="199.99"/></label><br/>
    生产日期：<label><input type="text" name="productionDate"/></label><br/>
    <label><input type="submit" value="提交"/> </label>
</form>
</body>
</html>
