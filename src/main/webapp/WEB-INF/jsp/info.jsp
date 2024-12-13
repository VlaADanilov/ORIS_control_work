<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.12.2024
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/recources/css/w3.css">
<html>
<head>
    <title>Info</title>
</head>
<body>
<div id = wrapper>
    <div id = header align="center">
        <h1>Информация о подарке с id = ${param.id}</h1>
    </div>
    <div align="center">
        <p>
            <strong><label>Name:</label></strong>
            ${gift.getGift_name()}
        </p>
        <p>
            <strong><label>Donator:</label></strong>
            ${gift.getGift_donator()}
        </p>
        <p>
            <strong><label>Recipient:</label></strong>
            ${gift.getGift_recipient()}
        </p>
        <p>
            <strong><label>Date:</label></strong>
            ${gift.getDate().toString()}
        </p>
        <button type="button" onclick="location.href = '${pageContext.servletContext.contextPath}/list'">Back</button>
    </div>
    <!--Запрет наплывания-->
    <div class="clear"></div>
    <!--Подвал-->
    <div id="footer">
        <p class="mail"><strong>E-mail<br>helloampro@gmail.com</strong></p>
    </div>
</div>
</body>
</html>
