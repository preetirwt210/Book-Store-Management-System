<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Order Details -Evergreen Bookstore Administration</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
<jsp:directive.include file="header.jsp"/> 

<div align="center">
    <h2 class="pageheading">Details of Order ID: ${order.orderId}</h2>
    </div>
    
    <c:if test="${message!=null }">
   <div align="center">
      <h4 class="message">${message }</h4>
   </div>
   </c:if>
    <div align="center">
            <h2>Order Overview</h2>
            <table border="1">
                <tr>
                   <td><b>Ordered By : </b></td>
                   <td>${order.customer.fullname}</td>
                </tr>
            <tr>
                   <td><b>Book Copies : </b></td>
                   <td>${order.bookCopies}</td>
                </tr>
                <tr>
                   <td><b>Total Amount : </b></td>
                   <td><fmt:formatNumber value="${order.total}" type="currency"/></td>
                </tr>
                <tr>
                   <td><b>Recipient Name : </b></td>
                   <td>${order.recipientName}</td>
                </tr>
                <tr>
                   <td><b>Recipient Phone : </b></td>
                   <td>${order.recipientPhone}</td>
                </tr>
                <tr>
                   <td><b>Payment Method : </b></td>
                   <td>${order.paymentMethod}</td>
                </tr>
                <tr>
                   <td><b>Shipping Address : </b></td>
                   <td>${order.shippingAddress}</td>
                </tr>
                <tr>
                   <td><b>Order Date : </b></td>
                   <td>${order.orderDate}</td>
                </tr>
            </table>
          </div>
          
          <div align="center">
              <h2>Ordered Books</h2>
              <table border="1">
                  <tr>
                    <th>Index</th>
                    <th>Book Title</th>
                    <th>Author</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>SubTotal</th>
              </tr>
              
              <c:forEach items="${order.orderDetails }" var="orderDetail" varStatus="status">
              <tr>
                 <td>${status.index +1}</td>
                  <td>${orderDetail.book.title }</td>
                 <td>${orderDetail.book.author }</td>
                 <td><fmt:formatNumber value="${orderDetail.book.price}" type="currency"/></td>
                  <td>${orderDetail.quantity}</td>
                  <td><fmt:formatNumber value="${orderDetail.subtotal}" type="currency"/></td>
                  
                 </tr>
              </c:forEach>
              
                <tr>
                  <td colspan="4" align="right">
                  <b><i>Total:</i></b>
                  </td>
                  <td>
                   <b> ${order.bookCopies }</b>
                  </td>
                  <td>
                   <fmt:formatNumber value="${order.total}" type="currency"/>
                  </td>
                </tr>
              </table>
          </div>
          
          <div align="center">
         <br/> <a href="edit_order?id=${order.orderId }">Edit this Order</a>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <a href="javascript:confirmDelete(${order.orderId })">Delete this Order</a>
          </div>
   
   
    <jsp:directive.include file="footer.jsp"/>
    <script >
    function confirmDelete(orderId){
    	if(confirm('Are you sure you want to delete the order with Id: ' + orderId + '?')){
    		
    		window.location='delete_order?id=' + orderId;
    	}
    }
    
    </script>
</body>
</html>