<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${book.title} - Online Books Store</title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

</head>
<body>
      
      <jsp:directive.include file="header.jsp"/>
      <div class="center">
       <table class="book">
           <tr>
           <td colspan="3" align="left"><p id="book-title">${book.title} </p>
           By<span id="author"> ${book.author}</span> </td>
           </tr>
           
           <tr>
           <td rowspan="2"><img class="book-large" src="data:imagejpg;base64,${book.base64Image }" /></td>
           <td valign="top" align="left"><c:forTokens items="${book.ratingStars}" delims="," var="star">
            <c:if test="${star eq 'on' }">
            <img src="images/rating_on.png" />
            </c:if>
            <c:if test="${star eq 'off' }">
            <img src="images/rating_off.png" />
            </c:if>
            <c:if test="${star eq 'half' }">
            <img src="images/rating_half.png" />
            </c:if>
       </c:forTokens>
       <a href="#reviews">&nbsp;&nbsp;${fn:length(book.reviews)} Reviews</a></td>
           <td valign="top" rowspan="2" width="10%"><h2>$${book.price}</h2> <br/><br/><button type="submit">Add to Cart</button> </td>
           </tr>
           
           <tr>
           <td id="description">${book.description}</td>
           </tr>
           <tr><td>&nbsp; &nbsp;</td></tr>
           <tr>
           <td><h2><a id="reviews" >Customer Reviews</a></h2></td>
           <td colspan="2"><button id="buttonWriteReview">Write customer reviews</button></td>
           </tr>
		           <tr>
		           <td colspan="3" align="left">
		              <table class="normal">
		              <c:forEach items="${book.reviews }" var="review">
		              <tr>
		              <td><c:forTokens items="${book.ratingStars}" delims="," var="star">
					            <c:if test="${star eq 'on' }">
					            <img src="images/rating_on.png" />
					            </c:if>
					            <c:if test="${star eq 'off' }">
					            <img src="images/rating_off.png" />
					            </c:if>
					            
					       </c:forTokens>
					       - <b>${review.headline}</b>
		                </td>
		                </tr>
		                <tr>
		                   <td>
		                     by ${review.customer.fullname} on ${review.reviewTime}
		                     </td>
		                 </tr>  
		                 <tr>
		                 <td> <i>${review.comment }</i></td></tr>
		                 <tr><td>&nbsp;</td></tr>  
		                 </c:forEach>
		              </table>
		           </td>
		           </tr>
       
       
       </table>
         </div>
      <br/><br/> 
      <jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#buttonWriteReview").click(function(){
		window.location='write_review?book_id=' + ${book.bookId};
	});
});
</script>
</html>