<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Customers -Evergreen Bookstore Administration</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
<jsp:directive.include file="header.jsp"/> 

<div align="center">
    <h1 class="pageheading">Customers Management</h1>
    <h3><a href="customer_form.jsp">Create new Customer</a></h3>
    </div>
    
    <c:if test="${message!=null }">
   <div align="center">
      <h4 class="message">${message }</h4>
   </div>
   </c:if>
    <div align="center">
         <table border="1" cellpadding="5">
         <tr>
         <th>Index</th>
         <th>ID</th>
         <th>E-mail</th>
         <th>FullName</th>
         <th>City</th>
         <th>Country</th>
         <th>Registered Date</th>
         <th>Actions</th>
         </tr>
     <c:forEach var="customer" items="${listCustomer }" varStatus="status" >
       <tr>
           <td>${status.index + 1} </td>
           <td>${customer.customerId}</td>
             <td>${customer.email}</td>
             <td>${customer.fullname}</td>
             <td>${customer.city}</td>
              <td>${customer.country}</td>
             <td><fmt:formatDate pattern="MM/dd/yyyy" value="${customer.registerDate}"/></td>
              <td>
               <a href="edit_customer?id=${customer.customerId }">Edit</a> |&nbsp;
               <a href="javascript:confirmDelete(${customer.customerId })">Delete</a>
              </td>
       </tr>
       
     
     </c:forEach>
         
         
         </table>
    </div>
   
   
    <jsp:directive.include file="footer.jsp"/>
    <script >
    
    
    function confirmDelete(customerId){
    	if(confirm('Are you sure you want to delete the user with Id: ' + customerId + '?')){
    		
    		window.location='delete_customer?id=' + customerId;
    	}
    }
    
    </script>
</body>
</html>