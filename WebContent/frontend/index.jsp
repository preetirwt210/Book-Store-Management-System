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
      
      
      <div align="center">
         
         <div align="center" style="width:80%; margin:0 auto;" >
         <h2>New Books: </h2>
      	<c:forEach items="${listNewBooks }" var="book">
      	<div style="display:inline-block; margin:0 auto;">
      <div>
      <a href="view_books?id=${book.bookId}">
       <img src="data:imagejpg;base64,${book.base64Image }" width="120" height="160"/></a></div><br/>
      <div><b> <a href="view_book?id=${book.bookId}">${book.title }</a></b></div>
       <div>rating *****</div>
        <div><i>by ${book.author}</i></div>
         <div><b>$ ${book.price }</b></div>	
         </div>
      	</c:forEach>
      </div>
      <div align="center" style="clear:both">
         <h2>Best-selling Books</h2>
         </div>
         <div align="center" style="clear:both">
         <h2>Most-favoured Books</h2>
         </div>
      <br/><br/><br/></br>
      </div>
      
      <br/><br/> 
      <jsp:directive.include file="footer.jsp"/>
</body>
</html>