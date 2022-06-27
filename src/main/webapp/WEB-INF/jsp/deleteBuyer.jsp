<!DOCTYPE html>
<html>
<body>

<h1>Delete Buyer</h1>

<form action="buyer-servlet" method="post">
  <label for="buyerName">Name: </label>${buyer.buyerName}<br><br>
  <label for="buyerAddress">Address: </label>${buyer.buyerAddress}<br><br>
  <input type="hidden" id="buyerId" name="buyerId" value=${buyer.buyerId}>
  <input type="submit" value="Delete">
</form>
  <button value="Back" onclick="history.back()">Back</button>

</body>
</html>