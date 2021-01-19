<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div align="Center">    
 <div>  
 <a href="${pageContext.request.contextPath }/admin/">
          <img src="../images/ever.png" title="Evergreen Books store" alt="Image not available" width="1000" height="100" />   
     </a>
     </div> 
      <div>
             Welcome, <c:out value="${sessionScope.useremail }"/> | <a href="logout">Logout</a><br/><br/>
      </div>
      <div id="headermenu" >
		        <div class="menu_item" >  
		      <a href="list_users" >
		           <img src="../images/user.png" width="100" height="50"/><br/>Users</a> 
		      </div>
		      <div class="menu_item" >
		      <a href="list_category" >
		      <img src="../images/category.jpg" width="100" height="50"/><br/>Categories</a>
		     </div>
		     <div class="menu_item" >
		      <a href="list_books" >
		      <img src="../images/book.jpg" width="100" height="50"/><br/>Books</a> 
		      </div>
		      <div class="menu_item">
		      <a href="customers" >
		      <img src="../images/customer.png" width="100" height="50"/><br/>Customers</a> 
		     </div>
		     <div class="menu_item">
		      <a href="reviews" >
		      <img src="../images/review.png" width="100" height="50"/><br/>Reviews</a> 
		      </div>
		      <div class="menu_item">
		      <a href="orders" >
		      <img src="../images/order.png" width="100" height="50"/><br/>Orders</a>
               </div>
      </div>
  </div>    