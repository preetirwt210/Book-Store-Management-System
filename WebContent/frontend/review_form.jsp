<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Write A Review</title>
	
	<link rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
	   <script type="text/javascript" src="js/jquery.validate.min.js"></script>
	</head>
	<body> 
	
      <jsp:directive.include file="header.jsp"/>
	<div align="center">
		
		<form>
		     <table class="normal" width="60%">
		        <tr>
		        <td><h2>Your Reviews</h2></td>
		        <td><h3>${loggedCustomer.fullname }</h3></td>
		        </tr>
		        <tr><td colspan="3"><hr/></td></tr>
		        <tr><td>
		        <span id="book-title"> ${book.title }</span><br/>
		           <img class="book-large" src="data:imagejpg;base64,${book.base64Image }" />
		        </td>
		        <td>
		        <input type="text" name="headline" size="60" placeholder="Headline or summary for your review (required)"/>
		       <br/><br/>
		       <textarea name="comment" cols="70" rows="10" placeholder="Write your review details.."></textarea>
		       </td> </tr>
		     </table>
		
		</form>
		
	</div>
<jsp:directive.include file="footer.jsp"/>
	</body>
	<script type="text/javascript">
	
	$(document).ready(function(){
		$("#formLogin").validate({
			rules:{
				email: {
					required : true,
					email:true
					},
		        password: "required",
			},
			messages:{
				email:{
					required:"Please enter email" ,
					email:"Please enter a valid email address"
				},
				password:"Please enter password"
			}
		});
	});
	  
	  
	     
	</script>
	</html>