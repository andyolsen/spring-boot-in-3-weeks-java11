<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Security Demo - Login</title>
        <style>
			body {
				font-family: Calibri;
			}
			h4 {
				width:100%;
				color: white;
				background-color: #e03416;
				padding: 5px;
			}
			label {
				width: 100px;
				float: left;	
			}
        </style>   
    </head>
    <body>
      
        <c:if test="${param.logout eq null}">
        
	        <h1>Login page</h1>

	        <form action="/login" method="post">
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	            <div>
	            	<label>User name: </label>
	            	<input type="text" name="username"> 
				</div>
	            <div>
	            	<label>Password: </label>
	            	<input type="password" name="password"> 
	            </div>
	            <div>
	            	<input type="submit" value="Log in">
	            </div>
	        </form>
	    
		    <c:if test="${param.error ne null}">
		        <h4>Invalid user name or password</h4>
		    </c:if>
		    
      	</c:if>

		<c:if test="${param.logout ne null}">
	        <h1>You have been logged out</h1>
	        <p>Click <a href="<spring:url value='/index' />">here</a> to go back to the home page.</p>
      	</c:if>
        
    </body>
</html>