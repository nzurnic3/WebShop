<!DOCTYPE html>
<html>
<body>

<h1>Delete Product</h1>

<form action="product-servlet" method="post">
  <label for="productName">Name: </label>${product.productName}<br><br>
  <label for="productPrice">Price: </label>${product.productPrice}<br><br>
  <label for="productStock">Stock: </label>${product.productStock}<br><br>
  <input type="hidden" id="productId" name="productId" value=${product.productId}>
  <input type="submit" value="Delete">
</form>
  <button value="Back" onclick="history.back()">Back</button>

</body>
</html>