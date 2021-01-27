<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Books in ${category.name} - Online Books Store</title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
      
      <jsp:directive.include file="header.jsp"/>
      
      
      <div class="center">
      	<h1>${category.name} </h1>
      </div>
      <div class="book_group" >
      	<c:forEach items="${listBooks }" var="book">
      	<div class="book">
      <div>
      <a href="view_books?id=${book.bookId}">
       <img class="book-small" 
       src="data:imagejpg;base64,${book.base64Image }"/></a></div><br/>
      <div><b> <a href="view_book?id=${book.bookId}">${book.title }</a></b></div>
       <div><c:forTokens items="${book.ratingStars}" delims="," var="star">
            <c:if test="${star eq 'on' }">
            <img src="images/rating_on.png" />
            </c:if>
            <c:if test="${star eq 'off' }">
            <img src="images/rating_off.png" />
            </c:if>
            <c:if test="${star eq 'half' }">
            <img src="images/rating_half.png" />
            </c:if>
       </c:forTokens></div>
        <div><i>by ${book.author}</i></div>
         <div><b>$ ${book.price }</b></div>	
         </div>
      	</c:forEach>
      </div>
      <br/><br/>
       
      <jsp:directive.include file="footer.jsp"/>
</body>
</html>