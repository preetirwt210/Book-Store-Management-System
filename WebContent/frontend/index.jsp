<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evergreen Books- Online Books Store</title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
      
      <jsp:directive.include file="header.jsp"/>
      
      
      <div class="center">
         
         <div>
         <h2>New Books: </h2>
      	<c:forEach items="${listNewBooks }" var="book">
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
      <div class="next-row">
         <h2>Best-selling Books</h2>
         </div>
         <div class="next-row">
         <h2>Most-favoured Books</h2>
         </div>
      <br/><br/><br/></br>
      </div>
      
      <br/><br/> 
      <jsp:directive.include file="footer.jsp"/>
</body>
</html>