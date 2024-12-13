
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/recources/css/w3.css">
<html>
<head>
  <title>List of gifts</title>
</head>
<body>
<div id = wrapper>
  <div id = header align="center">
    <h1>Подарки</h1>
  </div>
  <div>
    <ul class = "list1a">
      <c:forEach var = "gift" items="${list}" >
        <li onclick="location.href='${pageContext.servletContext.contextPath}/info?id=${gift.getGift_id()}'">
          <p>
            <strong><label>Name:</label></strong>
            ${gift.getGift_name()}
            <strong><label>Date:</label></strong>
              ${gift.getDate().toString()}
          </p>
        </li>
      </c:forEach>
    </ul>
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
