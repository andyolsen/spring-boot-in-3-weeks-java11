<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Security Demo - Greeting</title>
        <style>
			body {
				font-family: Calibri;
			}
        </style>   
    </head>
    <body>
        <h1>Greetings <c:out value="${pageContext.request.remoteUser}"/> </h1>

        <form action="/logout" method="post">
            <input type="submit" value="Log out">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>
    </body>
</html>