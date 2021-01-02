 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div align="Center">
          <div>
          <img  src="images/ever.png" title="Evergreen Books store" alt="Image not available">
           </div>
      <br/><br/>
      <div>
             <input type="text" name= "Keyword" size="50"/>
             <input type="button" value= "Search"/>
             
             &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
             
               <a href="Login">Sign In</a>  |
              <a href="register">Register</a>  |
              <a href="view_cart">Cart</a>
      </div>
      <div>&nbsp;&nbsp;</div>
      <div align="center">
      <c:forEach var="category" items="${listCategory }" varStatus="status">
      <a href="view_category?id=${category.categoryId }">
       <font size="+1"><b> ${category.name } </b></font>
        </a>
        <c:if test="${not status.last }">
        &nbsp;| &nbsp;
        </c:if>
      </c:forEach>
      </div>
      </div>
      