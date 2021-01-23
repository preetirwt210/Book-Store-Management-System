<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register As a customer</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

</head>
<body >
<jsp:directive.include file="header.jsp"/> 
   <div align="center">
   <h2 class="pageheading">Register as a customer</h2>
   </div>
    <div align="center">
     
    <form action="register_customer" method="post" id="customerForm" >
         <table class="form" >
         <tr>
              <td align="right">E-mail: </td>
              <td align="left"><input type="text" name="email"  id= "email" placeholder="email" size="45" /></td>         
         </tr>
         
         <tr>
              <td align="right">Full Name: </td>
               <td align="left"><input type="text" name="fullname" id= "fullname" placeholder="fullname" size="45" /></td>         
         </tr>
         
          <tr>
          <tr>
              <td align="right">Password: </td>
              <td align="left"><input type="password" name="password"  id= "password" placeholder="password" size="45"/>
              </td>         
         </tr>
         
         <tr>
              <td align="right">Confirm Password: </td>
               <td align="left"><input type="password" name="confirmPassword" id="confirmPassword" placeholder="confirm password" size="45" /></td>         
         </tr>
         
           <tr>
               <td align="right">Phone Number: </td>
               <td align="left"><input type="text" name="phone" id="phone" placeholder="your number" size="45" /></td>     
         </tr>
         <tr>
              <td align="right">Address: </td>
               <td align="left"><input type="text" name="address" id= "address" placeholder="address" size="45" /></td>         
         </tr>
          <tr>
              <td align="right">City: </td>
               <td align="left"><input type="text" name="city" id= "city" placeholder="city" size="45" /></td>    
         
          <tr>
           <tr>
              <td align="right">Zip Code: </td>
               <td align="left"><input type="text" name="zip" id= "zip" placeholder="zip" size="45" /></td>    
         
          <tr>
           <tr>
              <td align="right">Country: </td>
               <td align="left"><input type="text" name="country" id= "country" placeholder="country" size="45" /></td>    
         
          <tr>
          <td colspan="2" align="center">
              <input type="submit" value="Save" class="save"/> &nbsp;&nbsp;
              <input type="button" value="Cancel" onclick="javascript:history.go(-1);" class="cancel"/>
              </td>    
         </tr>
         
         </table>
         </form>
        
         </div>
   <jsp:directive.include file="footer.jsp"/>
</body>

<script type="text/javascript">
$(document).ready(function(){
	
	$("#customerForm").validate({
		rules:{
			email:{
				email:true,
				required:true
			},
			fullname: "required",
			password: "required",
			confirmPassword:{
				required:true,
				equalTo:"#password"
			}, 
			phone: "required",
			address: "required",
			city: "required",
			zip: "required",
			country: "required",
		},
		messages:{
			email:{
				email:"Please Enter a valid email address",
				required:"Please enter E-mail of the customer"
			} ,
			fullname: "Please Enter Full Name of the customer",
			password: "Please Enter Password of the customer",
			confirmPassword:{
				required:"Please Enter Confirmation Password of the customer",
				equalTo:"Password doesn't match"
			} ,
			phone: "Please Enter Phone Number of the customer",
			address:"Please Enter Address of the customer",
			city: "Please Enter City of the customer",
			zip: "Please Enter Zip Code of the customer",
			country: "Please Enter country of the customer"
		}
	});
});

  </script>
</html>