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

<h1>Read Sales</h1>
    <form action="sale-servlet" method="get">
    <table border="1">
        <tr>
            <td>Buyer name</td>
            <td>Product name</td>
            <td>Sale Date</td>
            <td>Sale Quantity</td>
            <td>Total Price</td>
        </tr>
                <c:forEach items="${sales}" var="sale">
                  <tr>
                    <td>${sale.buyer.buyerName}</td>
                    <td>${sale.product.productName}</td>
                    <td>${sale.saleDate}</td>
                    <td>${sale.saleQuantity}</td>
                    <td>${sale.totalPrice}</td>
                   </tr>
                 </c:forEach>
    </table>
    <hr>
    <button type="submit" name="option" value="create">Create New</button>
</form>
<button value="Back" onclick="history.back()">Back</button>

</body>
</html>