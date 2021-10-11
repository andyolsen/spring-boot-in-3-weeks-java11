<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Security Demo - Home</title>
        <style>
			body {
				font-family: Calibri;
			}
        </style>   
    </head>
    <body>
        <h1>Welcome!</h1>
        <p>Click <a href="<spring:url value='/greet' />">here</a> to see a greeting.</p>
    </body>
</html>