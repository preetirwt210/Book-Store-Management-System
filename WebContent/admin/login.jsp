<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin Login</title>
	
	<link rel="stylesheet" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
	   <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
	</head>
	<body> 
	<div align="center">
		<h1 class="pageheading">Book Store Administration</h1>
		<h2>Admin Login</h2>
	
	<form id="formLogin" action="login" method="post">
	   <table class="form" > 
	   <tr>
	       <td align="right">Email:</td>
	       <td align="left"><input type="text" name="email" id="email" size="20"></td> 
	  </tr>
		   <tr>
	       <td align="right">Password:</td>
	       <td align="left"><input type="password" name="password" id="password" size="20"></td> 
	   </tr>
	     <tr>
	          <td colspan="2" align="center">
	              <input type="submit" value="Login" class="save"/> 
	              </td> 
	      </tr>
	   </table>
	
	</form>
	</div>

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