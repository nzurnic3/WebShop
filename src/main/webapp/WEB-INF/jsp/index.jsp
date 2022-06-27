<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<h1>WebShop</h1>

<form action="option-servlet" method="get">
    <input type="radio" id="buyer" name="option" value="Buyer" checked="checked">
    <label for="html">Buyer</label><br>

    <input type="radio" id="product" name="option" value="Product">
    <label for="css">Product</label><br>

    <input type="radio" id="sale" name="option" value="Sale">
    <label for="javascript">Sale</label><br><br>

    <input type="submit" value="Select">
</form>

</body>
</html>
