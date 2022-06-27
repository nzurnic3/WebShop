<!DOCTYPE html>
<html>
<body>

<h1>${option} buyer</h1>

<form action="buyer-servlet" method="post">
  <label for="buyerName">Name:</label>
  <input type="text" id="buyerName" name="buyerName" value="${buyer.buyerName}"><br><br>
  <label for="buyerAddress">Address:</label>
  <input type="text" id="buyerAddress" name="buyerAddress" value="${buyer.buyerAddress}"><br><br>
  <input type="hidden" id="buyerId" name="buyerId" value=${buyer.buyerId}>
  <button type="submit" value="Submit">${option}</button>
</form>
  <button value="Back" onclick="history.back()">Back</button>


</body>
</html>
