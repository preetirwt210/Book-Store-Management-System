<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
 <c:if test="${category != null }">
   Edit Category-Evergreen Bookstore Administration
   </c:if>
   
   <c:if test="${category == null }">
  Create New Category-Evergreen Bookstore Administration
   </c:if>
   </title>
   <link rel="stylesheet" href="../css/style.css">
   <script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
   <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body >
<jsp:directive.include file="header.jsp"/> 

<div align="center">
    <h1 class="pageheading">
    <c:if test="${category != null }">
       Edit Category
    </c:if>
     <c:if test="${category == null }">
   Create New Category 
   </c:if>
    </h1>
    </div>
    <hr width="60%">
    <div align="center">
     <c:if test="${category != null }">
    <form action="update_category" method="post" id="categoryForm">
    <input type="hidden" name="categoryId" value="${category.categoryId }"/>
         </c:if>
         
         <c:if test="${category == null }">
    <form action="create_category" method="post" id="categoryForm">
         </c:if>
         <table>
         
         
         <tr>
              <td align="right">Name: </td>
               <td align="left"><input type="text" name="name" id= "name" placeholder="Category" size="20" value="${category.name }"/></td>         
         </tr>
         
         <tr><td>&nbsp;</td></tr>
          <tr>
          <td colspan="2" align="center">
              <input type="submit" value="Save" class="save"
              /> 
              <input type="button" value="Cancel" onclick="javascript:history.go(-1);"class="cancel"/>
              </td>    
         </tr>
         
         </table>
         </form>
         </div>
   <jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#categoryForm").validate({
		rules:{
				name:"required",
		},
		messages:{
				name:"Please enter category name"
			}
		
	});
});
  
     
</script>
</html>