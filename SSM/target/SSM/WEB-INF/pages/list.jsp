<%--
  Created by IntelliJ IDEA.
  User: Chenwz
  Date: 2019/12/23 0023
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>成功</h2>
${accounts}
<hr/>
<c:forEach items="${accounts}" var="account">
    ${account.id}&nbsp;&nbsp;${account.name}&nbsp;&nbsp;${account.money}<br/>
</c:forEach>
</body>
</html>
