<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
table.center {
  margin-left: auto;
  margin-right: auto;
}
</style>
</head>
<body>

<h1>All Products</h1>

<form action="product-servlet" method="get">
    <table border="1">
        <th>
            <td>Product Name</td>
            <td>Product Price</td>
            <td>Product Stock</td>
        </th>
        <c:forEach items="${products}" var="product">
          <tr>
            <td><input type="radio" name="equals" value=${product.productId}></td>
            <td>${product.productName}</td>
            <td>${product.productPrice}</td>
            <td>${product.productStock}</td>
           </tr>
         </c:forEach>
    </table>
    <hr>
    <%@ include file="crudButtons.html" %>
</form>
<button value="Back" onclick="history.back()">Back</button>

</body>
</html>