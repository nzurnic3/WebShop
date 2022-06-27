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

<h1>Sales</h1>

<form action="sale-servlet" method="post">
    <h2>Select Buyer</h2>
    <table border="1">
        <th>
            <td>Buyer Name</td>
            <td>Buyer Address</td>
        </th>
        <c:forEach items="${buyers}" var="buyer">
          <tr>
          <td><input type="radio" name="buyerEquals" value=${buyer.buyerId}></td>
           <td>${buyer.buyerName}</td>
            <td>${buyer.buyerAddress}</td>
           </tr>
           </c:forEach>
           </table>
           <br>
           <h2>Select Product</h2>
           <table border="1">
                   <th>
                       <td>Product Name</td>
                       <td>Product Price</td>
                       <td>Product Stock</td>
                   </th>
           <c:forEach items="${products}" var="product">
                     <tr>
                       <td><input type="radio" name="productEquals" value=${product.productId}></td>
                       <td>${product.productName}</td>
                       <td>${product.productPrice}</td>
                       <td>${product.productStock}</td>
                      </tr>
                    </c:forEach>

             </table>
             <br>
             <label for="saleDate">Enter date:</label>
               <input type="text" id="saleDate" name="saleDate"><br><br>
               <label for="saleQuantity">Enter quantity:</label>
               <input type="text" id="saleQuantity" name="saleQuantity"><br><br>
    <hr>
               <button type="submit" value="Submit">${option}</button>

</form>
<button value="Back" onclick="history.back()">Back</button>

</body>
</html>
