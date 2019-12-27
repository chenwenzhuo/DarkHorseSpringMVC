<%--
  Created by IntelliJ IDEA.
  User: Chenwz
  Date: 2019/12/18 0018
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h2>传统Java Web文件上传</h2>
<form action="fileupload/traditionalJavaWeb" method="post" enctype="multipart/form-data">
    <input type="file" name="fileUploader_javaWeb"/><br/>
    <input type="submit" value="提交"/>
</form>
<hr/>

<h2>SpringMVC文件上传</h2>
<form action="fileupload/springMVC" method="post" enctype="multipart/form-data">
    <input type="file" name="fileUploader_springMVC"/><br/>
    <input type="submit" value="提交"/>
</form>
<hr/>

<h2>跨服务器文件上传</h2>
<form action="fileupload/crossServer" method="post" enctype="multipart/form-data">
    <input type="file" name="fileUploader_crossServer"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
