<%--
  Created by IntelliJ IDEA.
  User: Chenwz
  Date: 2019/12/2 0002
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Annotations</title>

    <!--为@CookieValue注解创建一个Cookie-->
    <script type="text/javascript">
        // 路径(path)必须要填写，因为JS的默认路径是当前页，如果不填，此cookie只在当前页面生效！
        document.cookie="name=heythere;path=/";
        document.cookie="age=23;path=/"
    </script>
</head>
<body>

<a href="annotations/requestParam?msg=HeyThere">@RequestParam注解</a>
<br/><br/>

<form action="annotations/requestBody" method="post">
    用户名：<label><input type="text" name="username" value="hehe"/></label><br/>
    年龄：<label><input type="text" name="age" value="11"/></label><br/>
    <label><input type="submit" value="提交"/></label><br/>
</form>
<br/><br/>

<a href="annotations/pathVariable/24">@PathVariable注解</a>
<br/><br/>

<a href="annotations/requestHeader">@RequestHeader注解</a>
<br/><br/>

<a href="annotations/cookieValue">@CookieValue注解</a>
<br/><br/>

<a href="annotations/myCookieValue">@CookieValue注解——自定义Cookie</a>
<br/><br/>

<%--<a href="annotations/modelAttribute">@ModelAttribute注解</a>--%>
<form action="annotations/modelAttribute" method="post">
    @ModelAttribute注解<br/>

    产品名：<label><input type="text" name="productName" value="cup"/></label><br/>
    价格：<label><input type="text" name="price" value="9.99"/></label><br/>
    <label><input type="submit" value="提交"/></label><br/>
</form>
</body>
</html>
