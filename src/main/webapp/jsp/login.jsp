<%@ page import="by.itclass.constants.ApplicationConstants" %>
<%@ page import="by.itclass.constants.JspConstants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <img class="default_image" src="<%= JspConstants.BACKGROUND_IMAGE_JSP%>" alt="pizza">
    <div class="form-box">
        <h2>Login</h2>
        <form method="post" action="<%= ApplicationConstants.LOGIN_CONTROLLER%>">
            <input name="<%= JspConstants.LOGIN_PARAM%>" placeholder="Login">
            <input type="password" name="<%= JspConstants.PASS_PARAM%>" placeholder="Password">
            <input type="submit" value="Login">
        </form>
        <c:if test="${not empty message}">
            <h2 class="error">${message}</h2>
        </c:if>
    </div>
</body>
</html>
