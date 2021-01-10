<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Book-Evergreen Bookstore Administration</title>
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/jquery-ui.min.css">
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
</head>
<body >
<jsp:directive.include file="header.jsp"/> 

<div align="center">
    <h1 class="pageheading">
    <c:if test="${book != null }">
       Edit Book
    </c:if>
     <c:if test="${book == null }">
   Create New Book 
   </c:if>
    </h1>
    </div>
    <hr width="60%">
    <div align="center">
     <c:if test="${book != null }">
    <form action="update_book" method="post" id="bookForm">
    <input type="hidden" name="bookrId" value="${book.bookId }"/>
         </c:if>
         
         <c:if test="${book == null }">
    <form action="create_book" method="post" id="bookForm" enctype="multipart/form-data">
         </c:if>
         <table >
         <tr><td>Category</td>
         <td>
             <select name="category">
             <c:forEach items="${listCategory }" var="category">
             <option value="${ category.categoryId}">
                ${category.name }
                </option>
                </c:forEach>
                </select>
                </td>
         </tr>
         <tr>
              <td align="right">Title: </td>
              <td align="left"><input type="text" name="title"  id= "title" placeholder="title" size="20" value="${book.title}"/></td>         
         </tr>
         
         <tr>
              <td align="right">Author: </td>
               <td align="left"><input type="text" name="author" id= "author" placeholder="author" size="20" value="${book.author }"/></td>         
         </tr>
         
          <tr>
          <tr>
              <td align="right">ISBN: </td>
              <td align="left"><input type="text" name="isbn"  id= "isbn" placeholder="isbn" size="20" value="${book.isbn}"/>
              </td>         
         </tr>
         
         <tr>
              <td align="right">Publish Date: </td>
               <td align="left"><input type="text" name="publishDate" id="publishDate" value="${book.publishDate }"/></td>         
         </tr>
         
          <tr>
           <tr>
              <td align="right">Book Image: </td>
              <td align="left"><input type="file" name="image" id="image" size="20" /><br/>
                 <img id="thumbnail" alt="image-preview"  style="width:20%; margin-top:10px"/>   
                </td>      
         </tr>
         <tr>
              <td align="right">Price: </td>
               <td align="left"><input type="text" name="price" id= "price" placeholder="price" size="20" value="${book.price }"/></td>         
         </tr>
          <tr>
              <td align="right">Description: </td>
               <td align="left"><textarea rows="5" cols="50" name="description" id= "description" placeholder="desciption" ></textarea></td>
         
          <tr>
          <td colspan="2" align="center">
              <input type="submit" value="Save" class="save"
              /> &nbsp;&nbsp;
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
	$("#publishDate").datepicker();
	
	$("#image").change(function(){
		showImageThumbnail(this);
	});
	
	$("#bookForm").validate({
		rules:{
			category: "required",
			title: "required",
	        author: "required",
	        isbn: "required",
	        publishDate: "required",
	        image:"required",
	        price: "required",
	        description: "required",
	        
		},
		messages:{
			category: "Please select Category of the book",
			title: "Please Enter Title of the book",
	        author: "Please Enter Author of the book",
	        isbn: "Please Enter ISBN of the book",
	        publishDate: "Please Enter Publish Date of the book",
	        image:"Please Enter Image of the book",
	        price: "Please Enter Price of the book",
	        description: "Please Enter Description of the book"
		}
	});
});

  function showImageThumbnail(fileInput){
	  var file=fileInput.files[0];
	  
	  var reader= new FileReader();
	  
	  reader.onload=function(e){
		  $("#thumbnail").attr("src",e.target.result);
	  };
	  reader.readAsDataURL(file);
  }
  </script>
</html>