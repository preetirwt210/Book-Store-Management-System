<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New User-Evergreen Bookstore Administration</title>
</head>
<body >
<jsp:directive.include file="header.jsp"/> 

<div align="center">
    <h2> Create New User</h2>
    </div>
    <hr width="60%">
    <div align="center">
    <form action="create_user" method="post" onsubmit="return validateFormInput()">
         <table>
         <tr>
              <td align="right">Email: </td>
              <td align="left"><input type="text" name="email"  id= "email" placeholder="Email Id" size="20" value="${user.email}"/></td>         
         </tr>
         
         <tr>
              <td align="right">Full name: </td>
               <td align="left"><input type="text" name="fullname" id= "fullname" placeholder="Your Name" size="20" value="${user.fullname }"/></td>         
         </tr>
         <tr>
              <td align="right">Password: </td>
              <td align="left"><input type="password" name="password"  id= "password" placeholder="password" size="20" value="${user.password }"/></td>         
         </tr>
         <tr><td>&nbsp;</td></tr>
          <tr>
          <td colspan="2" align="center">
              <input type="submit" value="Save"
              /> 
              <input type="button" value="Cancel" onclick="javascript:history.go(-1);"/>
              </td>    
         </tr>
         
         </table>
         </form>
         </div>
   <jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">
   function validateFormInput(){
	   
	     var fieldEmail= document.getElementById("email");
	     var fieldFullname= document.getElementById("fullname");
	     var fieldPassword= document.getElementById("password");
	     ~
	     if(fieldEmail.value.length ==0){
	    	 alert("Email is required");
	    	 fieldEmail.focus();
	    	 return false;
	     }
	     if(fieldFullname.value.length ==0){
	    	 alert("Full Name is required");
	    	 fieldEmail.focus();
	    	 return false;
	     }
	     if(fieldPassword.value.length ==0){
	    	 alert("Password is required");
	    	 fieldEmail.focus();
	    	 return false;
	     }
	    
	     
   }
   return true;
     
</script>
</html>