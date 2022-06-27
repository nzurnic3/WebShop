<!DOCTYPE html>
<html>
<body>

<h1>${option} Product</h1>

<form action="product-servlet" method="post">
  <label for="productName">Name:</label>
  <input type="text" name="productName" value="${product.productName}"><br><br>
  <label for="productPrice">Price:</label>
  <input type="text" name="productPrice" value="${product.productPrice}"><br><br>
  <label for="productStock">Stock:</label>
  <input type="text" name="productStock" value="${product.productStock}"><br><br>
  <input type="hidden" name="productId" value=${product.productId}>
  <button type="submit" value="Submit">${option}</button>
</form>
  <button value="Back" onclick="history.back()">Back</button>


</body>
</html>