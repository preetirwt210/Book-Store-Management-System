<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${book.title} - Online Books Store</title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
      
      <jsp:directive.include file="header.jsp"/>
      <div align="center">
       <table width="80%" border="0">
           <tr>
           <td colspan="3" align="left"><h2>${book.title} </h2>by: ${book.author} </td>
           </tr>
           
           <tr>
           <td rowspan="2"><img src="data:imagejpg;base64,${book.base64Image }" width="240" height="300"/></td>
           <td valign="top" align="left">Rating *****</td>
           <td valign="top" rowspan="2" width="10%"><h2>$${book.price}</h2> <br/><br/><button type="submit">Add to Cart</button> </td>
           </tr>
           
           <tr>
           <td valign="top" style="text-align:justify;">${book.description}</td>
           </tr>
           <tr><td>&nbsp; &nbsp;</td></tr>
           <tr>
           <td><h2>Customer Reviews</h2></td>
           <td colspan="2"><button>Write customer reviews</button></td>
           </tr>
       
       
       </table>
         </div>
      <br/><br/> 
      <jsp:directive.include file="footer.jsp"/>
</body>
</html>