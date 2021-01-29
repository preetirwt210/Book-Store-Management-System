<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Review Added</title>
	
	<link rel="stylesheet" href="css/style.css">
	</head>
	<body> 
	
      <jsp:directive.include file="header.jsp"/>
	<div align="center">
		
		<form id="reviewForm" action="submit_review" method="post">
		     <table class="normal" width="60%">
		        <tr>
		        <td><h2>Your Reviews</h2></td>
		        <td><h3>${loggedCustomer.fullname }</h3></td>
		        </tr>
		        <tr><td colspan="3"><hr/></td></tr>
		        <tr><td>
		        <span id="book-title"> ${book.title }</span><br/>
		           <img class="book-large" src="data:imagejpg;base64,${book.base64Image }"/>
		        </td>
		        <td colspan="2">
		        <h2>Your Review has been posted Successfully.Thank you!</h2>
		        </td>
		        </tr>
		     </table>
		
		</form>
		
	</div>
<jsp:directive.include file="footer.jsp"/>
	</body>
	     
	
	</html>