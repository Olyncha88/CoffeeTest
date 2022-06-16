<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Coffee</title>
</head>
<body>
<h1><%= "Coffee from Italy" %>
</h1>
<br/>
<ul>
    <core:forEach var="coffee1" items="${coffee}">
        <li>${coffee1}</li>
    </core:forEach>
</ul>

</body>
</html>
