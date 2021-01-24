<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Profile</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body >
<jsp:directive.include file="header.jsp"/> 

<div align="center">
<br/>
    <h2 >Welcome, ${loggedCustomer.fullname }</h2>
    <br/>
    <table class="normal">
      <tr>
      <td ><b>E-mail Address: </b></td>
      <td align="left">${loggedCustomer.email}</td>
      </tr>
      
      <tr>
      <td ><b>Full Name: </b></td>
      <td align="left">${loggedCustomer.fullname}</td>
      </tr>
      
      <tr><td><b>Phone Number: </b></td>
      <td align="left">${loggedCustomer.phone}</td>
      </tr>
      
      <tr>
      <td ><b>Address: </b></td>
      <td align="left">${loggedCustomer.address}</td>
      </tr>
      
      <tr>
      <td ><b>City: </b></td>
      <td align="left">${loggedCustomer.city}</td>
      </tr>
      
      <tr>
      <td ><b>Zip Code: </b></td>
      <td align="left">${loggedCustomer.zipcode}</td>
      </tr>
      <tr>
      <td ><b>Country: </b></td>
      <td align="left">${loggedCustomer.country}</td>
      </tr>
    
    <tr><td>&nbsp;</td></tr>
    <tr>
    <td colspan="2" align="center"><b><a href="edit_profile">Edit My Profile</a></b></td>
    </table>
    
    </div>
    
    
    <jsp:directive.include file="footer.jsp"/>
</body>
</html>